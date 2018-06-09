import java.util.*;

class Solution {
    public int[] shortestToChar(String S, char C) {
        int ans[] = new int[S.length()];
        int n = ans.length;
        int cPos = -10001;
        for(int i = 0; i < n; i++){
        	if(S.charAt(i) == C){
        		cPos = i;
        	}
        	ans[i] = i-cPos;
        }

		cPos = 10001;
        for(int i = n-1; i > -1; i--){
        	if(S.charAt(i) == C){
        		cPos = i;
        	}
        	ans[i] = Math.min(cPos-i, ans[i]);
        }
        return ans;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(Arrays.toString(s.shortestToChar("aaba", 'b')));
    }
}