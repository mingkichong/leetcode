#!/usr/local/bin/bash

start_making(){
    ### Check if a directory does not exist ###
    if [ ! -d "./$1" ]; then
        mkdir $1;
        cp template_Solution.java ./$1/
        mv ./$1/template_Solution.java ./$1/Solution.java
        echo "java Solution" > ./$1/run.sh
        chmod 555 ./$1/run.sh
    else
        echo "directory ./$1/ already exists"
    fi
}

if [ "$1" != "" ]; then
	start_making $1
else
	echo Invalid: \$1 is not set
fi
