#!/usr/local/bin/bash

start_making(){
    ### Check if a directory does not exist ###
    if [ ! -d "./$1" ]; then
        mkdir $1;
        cat << EOF > ./$1/Solution.java
import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String __something() {
        return "SAMPLE";
    }

    public static void main(String args[]){
        Solution s = new Solution();
        if(Solution.RANDOM_INPUT){
            Random random = new Random();
        }
        if(Solution.DEBUG){
            System.out.println("DEBUG MESSAGE");
        }
        System.out.println(s.__something());
    }
}

EOF
        echo "javac *.java && java Solution" > ./$1/run.sh
        chmod 555 ./$1/run.sh
        echo "./$1/ directory created"
    else
        echo "directory ./$1/ already exists"
    fi

    if [ -d "./$1" ]; then
        if [ "$2" == "tree" ]; then
            cp ./Templates/Tree/TreeNode.java ./$1/
            cp ./Templates/Tree/TraverseOrder.java ./$1/
            echo "copied Tree classes to ./$1/"
        elif [ "$2" == "list" ]; then
            cp ./Templates/List/ListNode.java ./$1/
            echo "copied List classes to ./$1/"
        fi
    else
        echo "directory ./$1/ does not exist"
    fi
}

if [ "$1" != "" ]; then
	start_making $1 $2
else
	echo Invalid: \$1 is not set
fi
