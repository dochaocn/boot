#!/bin/bash

CLASS1=/C:/Users/Dc/IdeaProjects/boot/dubbo/src/main/classpath/
CLASS2=/C:/Users/Dc/IdeaProjects/boot/dubbo/target/classes/

LIB_JARS=${CLASS1}:${CLASS2}

java -classpath ${LIB_JARS} Main