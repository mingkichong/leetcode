import java.util.*;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int result [] = new int[nums.length];
        for (int i = 0, index = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[i + n];
        }
        return result;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.shuffle(new int[] {2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(s.shuffle(new int[] {1, 2, 3, 4, 4, 3, 2, 1}, 4)));
        System.out.println(Arrays.toString(s.shuffle(new int[] {1, 1, 2, 2}, 2)));
    }
}
