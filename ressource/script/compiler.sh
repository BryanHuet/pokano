#!/bin/bash

cd "$(dirname "$0")"/../..

[ -f dist/jar/json-simple-1.1.1.jar ] || sh ressource/script/telechargerLibrairie.sh

#Compiler sans prendre en compte les commentaires
javac -d "build" -cp "dist/jar/*" $(find . -name "*.java")

#Compiler en prenant en compte les commentaires
#javac -Xlint:unchecked -d "build" -cp "dist/jar/*" $(find . -name "*.java")