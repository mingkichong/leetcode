import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
    	Arrays.sort(nums);
    	int sum = 0;
    	for(int i = 0; i < nums.length; i+=2){
    		sum += nums[i];
    	}
        return sum;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	int nums [] = {1,4,3,2};
    	System.out.println(s.arrayPairSum(nums));
    }
}