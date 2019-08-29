import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public boolean isPerfectSquare(int num) {
        if(num < 1){
            return false;
        }
        int l = 1, r = 46341;
        while(l <= r){
            int mid = l + (r-l) / 2;
            if(mid * mid == num){
                return true;
            }
            else if(mid * mid < num){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        for(int i = 1; i <= 256; i++){
            System.out.println(i + "," + s.isPerfectSquare(i));
        }
    }
}

