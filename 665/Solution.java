import java.util.*;

class Solution {

    public boolean checkPossibility(int[] nums) {
        final int N = nums.length;
        if(N <= 2){
            return true;
        }
        int dipCount = 0;
        for(int i = 0; i < N - 2; i++){
            if(nums[i] <= nums[i+1] && nums[i+1] <= nums[i+2]){
            }
            else if(nums[i] <= nums[i+2]){
                if(nums[i+1] > nums[i+2] || nums[i+1] < nums[i]){
                    dipCount++;
                    nums[i+1] = nums[i];
                }
            }
            else if(nums[i] > nums[i+2]){
                if(nums[i] > nums[i+1] && nums[i+1] > nums[i+2]){
                    return false;
                }
                else if(nums[i] > nums[i+1] && nums[i+1] < nums[i+2]){
                    dipCount++;
                    nums[i] = nums[i+1];
                }
                else if(nums[i] <= nums[i+1]){
                    dipCount++;
                    nums[i+2] = nums[i+1];
                }
            }
        }
        if(dipCount > 1){
            return false;
        }
        return true;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
        int [] nums = {0,Integer.MAX_VALUE,Integer.MAX_VALUE,1,5,7,8,9,10};
        System.out.println(s.checkPossibility(nums));
    }
}

