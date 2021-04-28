#!/bin/bash
find -name "*.java" > sources.txt
javac -cp ./src @sources.txt -d ./out/ -classpath /home/mohsen/.m2/repository/com/google/code/gson/gson/2.8.6/gson-2.8.6.jar
jar cvfm client.jar ./MANIFEST.MF -C ./out/ .
