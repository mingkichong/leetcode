import java.util.*;
class Solution {
    public String convertToTitle(int n) {
    	StringBuilder sb = new StringBuilder();
    	while(n > 0){
	    	n--; // bring it to 0 index
    		int d = n % 26;
			n /= 26;
    		sb.append( (char) (d + 'A') );
    	}
        return sb.reverse().toString();
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	int n = 28;
    	System.out.println(s.convertToTitle(n));
    }
}