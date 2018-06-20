import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();

        // HashMap<Integer, Integer> map = new HashMap();
        // for(int i = 1; i <= nums.length; i++){
        //  map.put(i, map.getOrDefault(i, 0));
        // }
        // for(int n : nums){
        //  map.put(n, 1);
        // }
        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //  if(entry.getValue() == 0){
        //      list.add(entry.getKey());
        //  }
        // }

        //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/92956/Java-accepted-simple-solution
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -1 * nums[index];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}