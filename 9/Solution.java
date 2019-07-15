import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){ return false;}
        if(x <= 9){ return true; }
        int originalX = x;
        int reverse = 0;
        while(x > 0){
            reverse *= 10;
            int d = x % 10;
            x /= 10;
            reverse += d;
        }
        return reverse == originalX;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.isPalindrome(12321));
    }
}