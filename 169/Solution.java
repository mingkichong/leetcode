import java.util.*;


class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int num = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > max){
                num = entry.getKey();
                max = entry.getValue();
            }
        }
        return num;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {1,2,3,4,5,6,3,3,3,3,3};
        System.out.println(s.majorityElement(nums));
    }
}

