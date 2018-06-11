import java.util.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
		int l = 0, r = numbers.length-1;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l+1,r+1};
            }
            if(numbers[l] + numbers[r] < target){
                l++;
            }
            else{
                r--;
            }
        }
        return null;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(Arrays.toString(s.twoSum(new int[]{0,1,2,7,11,15}, 11)));
    }
}