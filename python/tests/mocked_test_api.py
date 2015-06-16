# -*- coding: utf-8 -*-

"""
Copyright (c) 2014-2015 Basis Technology Corporation.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
"""

# To run tests, run `py.test mocked_test_api.py`

import glob
import httpretty
import json
import os
import pytest
import re
from rosette.api import API, Operator, RosetteParameters, RntParameters, RniParameters, RosetteException

import sys
_IsPy3 = sys.version_info[0] == 3


request_file_dir = os.path.dirname(__file__) + "/../../mock-data/request/"
response_file_dir = os.path.dirname(__file__) + "/../../mock-data/response/"


def get_file_content(filename):
    with open(filename, "r") as f:
        return f.read()


def request_callback(request, uri, headers):
    # Filename is in the user_key field as a workaround as the mocked tests don't require a user key
    filename = request.headers["user_key"]
    # Construct the base name for the response file from the filename
    # Example filename: eng-doc-categories
    resp_file = response_file_dir + filename
    with open(resp_file + ".json", "r") as resp_json_file, open(resp_file + ".status", "r") as status_file:
        status = status_file.read()
        resp = resp_json_file.read()
        headers = {"Content-Length": len(resp)}
        return int(status), headers, resp


# Run through all files in the mock-data directory, extract endpoint, and create a list of tuples of the form
# (input filename, output status filename, output data filename, endpoint) as the elements
def categorize_reqs():
    # Define the regex pattern of file names. Example: eng-doc-categories.json
    pattern = re.compile("(\w+-\w+-([a-z_-]+))[.]json")
    files = []
    # Loop through all file names in the mock-data/request directory
    for full_filename in glob.glob(os.path.dirname(__file__) + "/../../mock-data/request/*.json"):
        filename = os.path.basename(full_filename)
        # Extract the endpoint (the part after the first two "-" but before .json
        endpoint = "/" + pattern.match(filename).group(2).replace("_", "/")
        # Add (input, output, endpoint) to files list
        files.append((pattern.match(filename).group(1),
                      response_file_dir + filename.replace("json", "status"),
                      response_file_dir + filename,
                      endpoint))
    return files


class RosetteTest:
    def __init__(self, filename=None):
        self.url = "https://api.rosette.com/rest/v1"
        # Set user key as filename as a workaround - tests don"t require user key
        # Filename is necessary to get the correct response in the mocked test
        key = filename
        self.api = API(service_url=self.url, user_key=key)
        # Default to RosetteParameters as self.params
        self.params = RosetteParameters()
        if key is not None:
            # Name matching endpoint requires RniParameters
            if "matched-name" in filename:
                self.params = RniParameters()
            # Name translation requires RntParameters
            elif "translated-name" in filename:
                self.params = RntParameters()
            # Find and load contents of request file into parameters
            with open(request_file_dir + filename + ".json", "r") as inp_file:
                params_dict = json.loads(inp_file.read())
            for key in params_dict:
                self.params[key] = params_dict[key]


# Setup for tests - register urls with HTTPretty and compile a list of all necessary information about each file
# in mock-data/request so that tests can be run
docs_list = categorize_reqs()


# Test that pinging the API is working properly
@httpretty.activate
def test_ping():
    with open(response_file_dir + "ping.json", "r") as ping_file:
        body = ping_file.read()
    httpretty.register_uri(httpretty.GET, "https://api.rosette.com/rest/v1/ping",
                           body=body, status=200, content_type="application/json")

    test = RosetteTest(None)
    op = test.api.ping()
    result = op.ping()
    assert result["message"] == "Rosette API at your service"


# Test that getting the info about the API is being called correctly
@httpretty.activate
def test_info():
    with open(response_file_dir + "info.json", "r") as info_file:
        body = info_file.read()
    httpretty.register_uri(httpretty.GET, "https://api.rosette.com/rest/v1/info",
                           body=body, status=200, content_type="application/json")

    test = RosetteTest(None)
    op = Operator(test.api, None)
    result = op.info()
    assert result["buildNumber"] == "6bafb29d"
    assert result["name"] == "Rosette API"


@httpretty.activate
def call_endpoint(input_filename, expected_status_filename, expected_output_filename, rest_endpoint):
    httpretty.register_uri(httpretty.POST, "https://api.rosette.com/rest/v1" + rest_endpoint,
                           # body=request_callback,
                           status=get_file_content(expected_status_filename),
                           body=get_file_content(expected_output_filename))
    with open(response_file_dir + "info.json", "r") as info_file:
        body = info_file.read()
    httpretty.register_uri(httpretty.GET, "https://api.rosette.com/rest/v1/info",
                           body=body, status=200, content_type="application/json")

    error_expected = False
    # Create an instance of the app, feeding the filename to be stored as the user key so the response will be correct
    test = RosetteTest(input_filename)
    # Open the expected response file and store the data
    with open(expected_output_filename, "r") as expected_file:
        expected_result = json.loads(expected_file.read())
    # Check to see if this particular request should throw an exception for an unsupported language
    if "code" in expected_result:
        if expected_result["code"] == "unsupportedLanguage":
            error_expected = True
    functions = {"/categories":          test.api.categories(),
                 "/entities":            test.api.entities(None),
                 "/entities/linked":     test.api.entities(True),
                 "/language":            test.api.language(),
                 "/matched-name":        test.api.matched_name(),
                 "/morphology/complete": test.api.morphology(),
                 "/sentiment":           test.api.sentiment(),
                 "/translated-name":     test.api.translated_name()}
    # Find the correct function based on the endpoint and create an operator
    op = functions[rest_endpoint]
    # If the request is expected to throw an exception, try complete the operation and pass the test only if it fails
    if error_expected:
        try:
            op.operate(test.params)
            assert False
        except RosetteException:
            assert True
        return

    # Otherwise, actually complete the operation and check that it got the correct result
    result = op.operate(test.params)
    if result == expected_result:
        assert True
    else:
        assert False


# Test all other endpoints
# docs_list is the list of information from documents in the mock-data/request directory above
# @pytest.mark.parametrize means that it will call the below test for each tuple
# in the docs_list feeding the elements of the tuple as arguments to the test
@pytest.mark.parametrize("input_filename, expected_status_filename, expected_output_filename, rest_endpoint", docs_list)
def test_all(input_filename, expected_status_filename, expected_output_filename, rest_endpoint):
    # @httpretty and @pytest cannot co-exist, so separate the function definition
    call_endpoint(input_filename, expected_status_filename, expected_output_filename, rest_endpoint)
