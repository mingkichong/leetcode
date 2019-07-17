import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int currentIndex = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[currentIndex]){
                currentIndex++;
                nums[currentIndex] = nums[i];
            }
        }
        return currentIndex + 1;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        // int [] nums = {5,5,5,6,6,7};
        int [][] inputs = { {5,5,5,6,6,7},
                            {0,1,1,3,4,5,6,6,6,7,8,8,9,9,10,10},
                            {1,1,1,1,1,1},
                            {},
                            {6}};
        for(int[] nums : inputs){
            int length = s.removeDuplicates(nums);
            for(int i = 0; i < length; i++){
                System.out.print(nums[i]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}
