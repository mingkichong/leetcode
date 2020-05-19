import java.util.*;

class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n[] = new int[nums.length];
        System.arraycopy(nums, 0, n, 0, nums.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = map.get(n[i]);
        }
        return nums;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrent(new int[]{8,1,2,2,3})));
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrent(new int[]{6,5,4,8})));
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrent(new int[]{7,7,7,7})));
    }
}
