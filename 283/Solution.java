import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        for(int lastPosition = 0, current = 0; current < nums.length; current++){
            if(nums[current] != 0){
                swap(nums, lastPosition, current);
                lastPosition++;
            }
        }
    }

    public void swap(int [] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {0,0,0,1,0,0,4,0,0,0,5,0,0,0,3};
        System.out.println(Arrays.toString(nums));
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
