import java.util.*;

class Solution {

    public int maxProduct(int[] nums) {
        long max = Long.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            long product = 1;
            for(int j = i; j < nums.length; j++){
                product *= nums[j];
                max = Math.max(product, max);
            }
        }
        return (int)max;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.maxProduct(new int[]{2,3,-2,4}));
    }
}
