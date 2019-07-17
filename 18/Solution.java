import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int targetSum) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int i = 0 ; i < nums.length-2; i++){
            for(int j = i + 1; j < nums.length-1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int target = -1 * (nums[i] + nums[j] + nums[k]) + targetSum;
                    if(map.containsKey(target)){
                        int targetCount = 0;
                        targetCount += (nums[i] == target) ? 1 : 0;
                        targetCount += (nums[j] == target) ? 1 : 0;
                        targetCount += (nums[k] == target) ? 1 : 0;
                        if(targetCount < map.get(target)){
                            Integer [] sum = new Integer[]{nums[i], nums[j], nums[k], target};
                            Arrays.sort(sum);
                            set.add(Arrays.asList(sum));
                        }
                    }
                }
            }
        }
        List<List<Integer>> answer = new ArrayList<>(set);
        return answer;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int targetSum = 1;
        System.out.println(Arrays.deepToString(s.fourSum(nums, targetSum).toArray()));
    }
}
