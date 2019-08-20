import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    public int findUnsortedSubarray(int[] nums) {
        int N = nums.length;
        int l = 0, r = N-1;
        while(l <= r && l < N && isFrontSmallest(nums, l, r)){
            while(l+1 < N && nums[l] == nums[l+1]){
                l++;
            }
            l++;
        }
        while(l <= r && r >= 0 && isBackLargest(nums, l, r)){
            while(r-1 >= 0 && nums[r] == nums[r-1]){
                r--;
            }
            r--;
        }
        if(Solution.DEBUG){
            System.out.println(String.format("%s,%s", l, r));
        }
        return r - l + 1;
    }

    boolean isFrontSmallest(int [] nums, int l, int r){
        if(l == r){
            return true;
        }
        int min = nums[l];
        for(int i = l+1; i <= r; i++){
            min = Math.min(min, nums[i]);
        }
        return nums[l] == min;
    }

    boolean isBackLargest(int [] nums, int l, int r){
        if(l == r){
            return true;
        }
        int max = nums[r];
        for(int i = r-1; i >= l; i--){
            max = Math.max(max, nums[i]);
        }
        return nums[r] == max;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {1,2,3,4,5,6,7,8};
        int min = nums.length, max = 0;
        if(Solution.DEBUG){
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
            System.out.println("length: " + nums.length + " sort: " + min + "," + max);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(s.findUnsortedSubarray(nums));
    }
}

