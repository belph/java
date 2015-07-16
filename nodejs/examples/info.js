"use strict";

var Api = require("./../lib/rosetteApi");
var ArgumentParser = require('../node_modules/argparse').ArgumentParser;

var parser = new ArgumentParser({
  addHelp:true,
  description: "Get information about Rosette API"
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

var api = new Api(args.key, args.service_url);
var result = api.info();

console.log(result);
