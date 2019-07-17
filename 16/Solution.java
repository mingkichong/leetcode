import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //brute force O(n^3)
        int N = nums.length;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < N - 2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int k = j+1; k < N; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == target){
                        System.out.println(nums[i] + "," + nums[j] + "," + nums[k]);
                        return target;
                    }
                    set.add(sum);
                }
            }
        }
        int prev = set.first();
        for(Integer i : set){
            if(target == i){
                return target;
            } 
            else if(target < i){
                return (i - target) < (target - prev) ? i : prev;
            }
            prev = i;
        }
        return prev;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {-94,-92,31,60,-31,-5,0,-48,-30,96,-93,47,56,-45,-77,-56,-10,43,63,90,-100,65,-80,94,98,65,-56,-45,-87,78,47,99,47,-64,77,-70,81,76,80,36,23,-99,-79,-91,66,95,-1,-1,33,24,-51,-86,95,-58,-96,84,61,97,-58,-37,22,-68,24,-4,-67,-67,88,82,-79,56,-100,58,-54,-32,-74,-68,67,18,-71,-48,83,-21,-99,51,-8,-16,12,34,-60,-44,-35,-62,14,-59,-34,89,-53,53,-78,94,77,-61,-49,20,-27,8,76,-96,-16,-6,93,-33,-36,-62,-22,-67,-30,19,54,-20,-36,-8,-31,-67,24,31,0,28,16,17,-11,-69,-43,-53,93,44,-34,73,-89,45,-46,63,6,-49,47,93,82,33,-14,-20,25,-1,-48,-56,47,-49,43,4,-68,37,86,-6,-56,91,-24,-43,40,40,-51,-58,-64,-56,84,-22,-81,32,55,32,43,-13,-100,-15,66,61,85,-81,57,20,64,-57,-68,8,-60,65,97,3,33,-68,40,83,-79,38,32,-41,67,-72,-54,22,54,-49};
        System.out.println(s.threeSumClosest(nums, -121));
    }
}
