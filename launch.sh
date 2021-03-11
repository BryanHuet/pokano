#!/bin/bash

[ -d build ] || mkdir build

sh ressource/script/compiler.sh

if [[ "$OSTYPE" == "linux-gnu" ]]; then
	java -cp "build:dist/jar/*" src.Main
else
	java -cp "build;dist/jar/*" src.Main
fi