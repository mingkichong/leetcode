import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
    	if(s.length() <= numRows || numRows == 1){
    		return s;
    	}
    	StringBuilder sb[] = new StringBuilder[numRows];
    	for(int i = 0; i < sb.length; i++){
    		sb[i] = new StringBuilder();
    	}
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		int z  = i % (numRows * 2 - 2);
    		if (z < numRows){ //vertical
    			sb[z].append(c);
    		}
    		else{ // diagonal
    			sb[numRows * 2 - 2 - z].append(c);
    		}
    	}
    	StringBuilder sbAnswer = new StringBuilder();
    	for(StringBuilder b : sb){
    		sbAnswer.append(b.toString());
    	}
        return sbAnswer.toString();
    }

    public static void main(String args[]){
    	Solution s 	 = new Solution();
    	String input = "PAYPALISHIRING";
    	int numRows  = 4;
    	System.out.println(s.convert(input, numRows));
    }
}