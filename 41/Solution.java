import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int n = 1; ;n++){
            if(!set.contains(n)){
                return n;
            }
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {1,2,0,4,6,3};
        System.out.println(s.firstMissingPositive(nums));
    }
}
