#!/bin/bash

cd "$(dirname "$0")"/../..

[ -d dist ] || mkdir dist
[ -d dist/jar ] || mkdir dist/jar

cd dist/jar/

if test ! -s json-simple-1.1.1.jar;
	then 
		wget http://www.java2s.com/Code/JarDownload/json-simple/json-simple-1.1.1.jar.zip
		unzip json-simple-1.1.1.jar.zip
fi