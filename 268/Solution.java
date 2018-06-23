import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        boolean[] n = new boolean[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            n[nums[i]] = true;
        }
        for(int i = 0; i < n.length; i++){
            if(!n[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}