import java.util.*;

class Solution {
    public int arrangeCoins(int n) {
        int i = 0;
        while(n > i){
        	i++;
        	n -= i;
        }
        return i;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.arrangeCoins(8));
    }
}