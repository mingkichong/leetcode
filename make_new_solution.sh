#!/usr/local/bin/bash

start_making(){
	mkdir $1;
	cp template_Solution.java ./$1/
	mv ./$1/template_Solution.java ./$1/Solution.java
}

if [ "$1" != "" ]; then
	start_making $1
else
	echo Invalid: \$1 is not set
fi
