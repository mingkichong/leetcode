import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        int n = nums[0];
        for(int i = 1; i < nums.length; i++){
            n ^= nums[i];
        }
        return n;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {4,1,2,1,2,4,9,6,2,2,6};
        System.out.println(s.singleNumber(nums));
    }
}
