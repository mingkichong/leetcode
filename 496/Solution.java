import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int[] ans = new int[nums1.length];
    	for(int i = 0; i < ans.length; i++){
    		ans[i] = -1;
    	}
        for(int a = 0; a < nums1.length; a++){
        	int i = getIndexOfNums2(nums1[a], nums2);
        	for(;i < nums2.length && nums2[i] <= nums1[a]; i++){
        	}
        	if(i < nums2.length){
        		ans[a] = nums2[i];
        	}
        }
        return ans;
    }

	public int getIndexOfNums2(int n, int[] nums2){
		for(int i = 0; i < nums2.length; i++){
			if(nums2[i] == n){
				return i;
			}
		}
		return -1;
	}

    public static void main(String args[]){
    	Solution s = new Solution();
    	// System.out.println(Arrays.toString(s.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    	System.out.println(Arrays.toString(s.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
    }
}