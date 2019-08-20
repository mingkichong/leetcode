import java.util.*;

class Solution {

    public boolean checkPossibility(int[] nums) {
        if(nums.length <= 2){
            return true;
        }
        int dipCount = 0;
        for(int i = 1; i < nums.length - 1; i++){
            // if(){
            //     dipCount++;
            // }
            // else if(){
            //     dipCount++;
            // }
            // else if(){
            //     return false;
            // }
        }
        if(dipCount > 1){
            return false;
        }
        return true;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
        int [] nums = {0,Integer.MAX_VALUE,1,6};
        System.out.println(s.checkPossibility(nums));
    }
}

