import java.util.*;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = binarySearch(nums, target);
        if(i == -1){
            return new int[]{-1,-1};
        }
        int l = i-1, r = i+1;
        while(l >= 0 && nums[l] == nums[i]){
            l--;
        }
        while(r < nums.length && nums[r] == nums[i]){
            r++;
        }
        l++;r--;
        return new int[]{l,r};
    }

    int binarySearch(int[] nums, int target){
        int l = 0, r = nums.length-1;
        while(l <= r){
            int m = (r + l)/2;
            if(nums[m] == target){
                return m;
            }
            else if(nums[m] < target){
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {8,8,8,8};
        int target = 8;
        System.out.println(Arrays.toString(s.searchRange(nums, target)));
    }
}
