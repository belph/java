"use strict";

var Api = require("./../lib/rosetteApi");
var ArgumentParser = require('../node_modules/argparse').ArgumentParser;
var DocumentParameters = require("./../lib/DocumentParameters");
var rosetteConstants = require("./../lib/rosetteConstants.js");

var parser = new ArgumentParser({
  addHelp:true,
  description: "Get part-of-speech tags for words in text"
});
parser.addArgument(
  ["--key"],
  {
    help: "Rosette API key",
    required: true
  }
);
parser.addArgument(
  ["--service_url"],
  {
    help: "Optional user service URL"
  }
);
var args = parser.parseArgs();

var docParams = new DocumentParameters();
var content = "The fact is that the geese just went back to get a rest and I'm not banking on their return soon";
docParams.setItem("content", content);

var api = new Api(args.key, args.service_url);
var result = api.morphology(docParams, rosetteConstants.morpholoyOutput.PARTS_OF_SPEECH);

console.log(result);
