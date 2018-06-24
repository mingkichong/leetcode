import java.util.*;

class Solution {
	public boolean rotateString(String A, String B) {
       	if(A.length() != B.length()){
            return false;
        }
        String aa = A + A;
        return aa.indexOf(B) > -1;
	}

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.rotateString("abcde", "cdeab"));
    }
}