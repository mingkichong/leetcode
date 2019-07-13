import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            Integer b = map.get(target - nums[i]);
            if(b != null && b != i){
                return new int[]{i, b};
            }
        }
        return null;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{1,2,3,4,5,6}, 7)));
    }
}
