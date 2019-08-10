import java.util.*;

//https://leetcode.com/problems/first-missing-positive/

class Solution {
    public int firstMissingPositive(int[] nums) {
        if(isAllZeroNegative(nums) || findSmallestPositiveInt(nums) > 1){
            return 1;
        }


        return -1;
    }

    boolean isAllZeroNegative(int[] nums){
        for(int n : nums){
            if(n > 0){
                return false;
            }
        }
        return true;
    }
    int findSmallestPositiveInt(int[] nums){
        boolean hasFound = false;
        int ans = Integer.MAX_VALUE;
        for(int n : nums){
            if(n > 0 && ans > n){
                ans = n;
                hasFound = true;
            }
        }
        return hasFound ? ans : -1;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {7,8,9,11,12};
        System.out.println(s.firstMissingPositive(nums));
    }
}
