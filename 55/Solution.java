import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    //time O(n^2)
    //space O(1) if we are allowed change the input array
    //  otherwise, use a boolean array as a memo table
    public boolean canJump(int[] nums) {
        if(nums.length < 1){ return false; }
        nums[nums.length - 1] = -1;
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 1; j <= nums[i] && i+j < nums.length; j++){
                if(nums[i+j] < 0){
                    nums[i] = -1;
                    break;
                }
            }
        }
        return nums[0] < 0;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{2,3,1,1,4}));
        System.out.println(s.canJump(new int[]{3,2,1,0,4}));
    }
}

