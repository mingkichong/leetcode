import java.util.*;

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        int leftSum = 0, rightSum = sum;
        for(int i=0;i<nums.length;i++){
            rightSum = rightSum - nums[i];
            leftSum = sum - nums[i] - rightSum;
            if (leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.pivotIndex(new int[]{1, 2, 3}));
    }
}