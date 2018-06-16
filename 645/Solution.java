import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
    	HashSet<Integer> set = new HashSet<>();
    	int dup = 0; int miss = 0;

    	for(int n : nums){
    		if(set.contains(n)){
    			dup = n;
    		}
    		else{
    			set.add(n);
    		}
    	}
    	for(int i = 1; i <= nums.length; i++){
    		if(!set.contains(i)){
    			miss = i;
    		}
    	}

        return new int[]{dup, miss};
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(Arrays.toString(s.findErrorNums(new int[]{1,5,3,2,2,7,6,4,8,9})));
    }
}