import java.util.*;

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
    	int lineWidth = 0;
    	int lineCount = 0;
        for(char c : S.toCharArray()){
        	lineWidth += widths[c - 'a'];
        	if(lineWidth > 100){
        		lineCount++;
        		lineWidth = widths[c - 'a'];
        	}
        }
        if(lineWidth > 0){
        	lineCount++;
        }
        return new int[] {lineCount, lineWidth};
    }

    public static void main(String args[]){
    	int widths[] = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    	String S = "bbsdgwgerfdfh";

    	Solution s = new Solution();
    	System.out.println(Arrays.toString(s.numberOfLines(widths, S)));
    }
}