import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0){
            return false;
        }
        if(k >= nums.length - 1){
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 1; i++){
                if(Math.abs((long)nums[i] - (long)nums[i+1]) <= t){
                    return true;
                }
            }
            return false;
        }
        long head = nums[0];
        TreeMap<Long, Integer> map = new TreeMap<>();
        for(int j = 1; j <= k && j < nums.length; j++){
            map.put((long)nums[j], map.getOrDefault((long)nums[j], 0) + 1);
        }
        for(int i = 1; i < nums.length; i++){
            if(map.size() < 1){
                break;
            }
            if(Math.abs((map.firstKey() - head)) <= t || Math.abs((map.lastKey() - head)) <= t){
                return true;
            }
            head = nums[i];
            if(map.get(head) == 1){
                map.remove(head);
            }
            else{
                map.put(head, map.get(head) - 1);
            }

            if(i + k < nums.length){
                map.put((long)nums[i+k], map.getOrDefault((long)nums[i+k], 0) + 1);
            }
        }
        return false;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = new int[]{1,5,9,1,5,9};
        int k = 2;
        int t = 3;
        System.out.println(s.containsNearbyAlmostDuplicate(nums, k, t));
    }
}

