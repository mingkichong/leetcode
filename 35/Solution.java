import java.util.*;

class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(target <= nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {14,5,6,8,4,6,8,2,3,6,4,5,0,8,9,1,2,3,4,5};
        nums = Arrays.stream(nums).distinct().sorted().toArray();
        System.out.println(Arrays.toString(nums));
        int target = 10;
        System.out.println(s.searchInsert(nums, target));
    }
}
