import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
    	int ans = Integer.MIN_VALUE;
   //  	for(int i = 0; i < nums.length-2; i++){
			// for(int j = i+1; j < nums.length-1; j++){
			// 	for(int k = j+1; k < nums.length; k++){
			// 		int prod = nums[i] * nums[j] * nums[k];
			// 		ans = (prod > ans) ? prod : ans;
			// 	}
			// }
   //  	}

     	// Arrays.sort(nums);
    	// return Math.max( nums[0] * nums[1] * nums[nums.length-1], nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1]);

    	int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
    	
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;

		for(int n : nums){
			if(n > max1){
				max3 = max2;
				max2 = max1;
				max1 = n;
			}
			else if(n > max2){
				max3 = max2;
				max2 = n;
			}
			else if(n > max3){
				max3 = n;
			}

			if(n < min1){
				min2 = min1;
				min1 = n;
			}
			else if(n < min2){
				min2 = n;
			}

		}
		return Math.max( min1 * min2 * max1, max3 * max2 * max1);
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.maximumProduct(new int[]{-5,-1,1,2,3,4}));
    }
}