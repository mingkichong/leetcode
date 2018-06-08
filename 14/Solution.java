import java.util.*;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0){
    		return "";
    	}

    	int shortestLength = Integer.MAX_VALUE;
    	String shortestString = "";

    	for(String s : strs){
    		if(s.length() < shortestLength){
    			shortestLength = s.length();
    			shortestString = s;
    		}
    	}

        int length = shortestString.length();
        while(length > 0){
        	String sstr = shortestString.substring(0, length);
        	boolean isPrefix = true;
        	for(int i = 0; i < strs.length; i++){
        		if(sstr.compareTo(strs[i].substring(0, length)) != 0){
        			isPrefix = false;
        			break;
        		}
        	}
        	if(isPrefix){
        		return sstr;
        	}
        	else{
        		length--;
        	}
        }

        return "";
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.longestCommonPrefix(new String[]{"ca","a"}));
    }
}