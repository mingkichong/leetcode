#!/usr/local/bin/bash

start_making(){
    ### Check if a directory does not exist ###
    if [ ! -d "./$1" ]; then
        mkdir $1;
        cat << EOF > ./$1/Solution.java
import java.util.*;

class Solution {
    public String __something() {
        return "SAMPLE";
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
        System.out.println(s.__something());
    }
}

EOF
        echo "javac *.java && java Solution" > ./$1/run.sh
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
