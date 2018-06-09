import java.util.*;

public class Solution {
    public int removeElement(int[] nums, int val) {
    	if(nums.length == 0){
    		return 0;
    	}
    	int l = 0, r = nums.length-1;

    	while(true){
    		while(l < nums.length && nums[l] != val){
    			l++;
    		}
    		while(r > -1 && nums[r] == val){
    			r--;
    		}

			if(l > r){
				break;
			}

			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
    	}

    	System.out.println(Arrays.toString(nums));
    	for(int i = 0; i < nums.length; i++){
    		if(nums[i] == val){
    			return i;
    		}
    	}

    	return nums.length;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.removeElement(new int[]{3,2,2,3}, 3));
    }
}