import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String __something() {
        return "SAMPLE";
    }

    //time O(n) space O(n)
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            if(set.contains(n)){
                list.add(n);
            }
            else{
                set.add(n);
            }
        }
        return list;
    }

    //time O(n.logn) space O(1)
    public List<Integer> findDuplicates2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                list.add(nums[i]);
            }
        }
        return list;
    }

    //time O(n) space O(1)
    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                list.add(index+1);
            }
            nums[index] *= -1;
        }
        return list;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = new int[]{4,8,7,2,3,2,3,1};
        System.out.println(s.findDuplicates3(nums));
    }
}

