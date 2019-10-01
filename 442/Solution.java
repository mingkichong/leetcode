import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String __something() {
        return "SAMPLE";
    }

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

    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> list = new ArrayList<>();

        return list;
    }


    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = new int[]{1,2,3,4,5,6,7,8,9,0};
        System.out.println(s.findDuplicates(nums));
    }
}

