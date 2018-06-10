import java.util.*;

class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.compareTo(word.toUpperCase()) == 0){
        	return true;
        }
        else if(word.compareTo(word.toLowerCase()) == 0){
        	return true;
        }
        else if(word.compareTo(word.toUpperCase().substring(0,1).concat(word.toLowerCase().substring(1,word.length()))) == 0) {
        	return true;
        }
        return false;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.detectCapitalUse("WoRD"));
    }
}