import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;
    public int findUnsortedSubarray(int[] nums) {
        int N = nums.length;
        int l = N-1, r = 0;
        int min = nums[l], max = nums[r];
        for(int i = l-1; i >= 0; i--){
            min = Math.min(min, nums[i]);
            if(nums[i] > min){
                l = i;
            }
        }
        for(int i = r; i < N; i++){
            max = Math.max(max, nums[i]);
            if(nums[i] < max){
                r = i;
            }
        }
        if(Solution.DEBUG){
            System.out.println(l + "," + r);
        }
        if(r-l <= 0){
            return 0;
        }
        return r - l + 1;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {-1, -5, -3, -1, 1, 2, 5};
        int min = nums.length, max = 0;
        if(Solution.RANDOM_INPUT){
            Random random = new Random();
            nums = new int[random.nextInt(30) + 5];
            for(int i = 0; i < nums.length; i++){
                nums[i] = random.nextInt(10) - 5;
            }
            int shuffles = random.nextInt(5) + 1;
            min = nums.length; max = 0;
            for(int i = 0; i < shuffles; i++){
                int start = random.nextInt(3) == 0 ? 0 : (random.nextInt(nums.length / 5) + 1);
                int end = nums.length / 5 + random.nextInt(nums.length - start - nums.length / 5) + 1;
                min = Math.min(min, start);
                max = Math.max(max, end);
                Arrays.sort(nums, start, end);
            }
            nums[0] = random.nextInt(3) == 0 ? -5 : nums[0];
            nums[nums.length-1] = random.nextInt(3) == 0 ? 5 : nums[nums.length-1];
        }
        if(Solution.DEBUG){
            System.out.println("length: " + nums.length + (Solution.RANDOM_INPUT ? " sort: " + min + "," + max : ""));
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(s.findUnsortedSubarray(nums));
    }
}

