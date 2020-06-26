import java.util.*;

class Solution {
    public int maxPower(String s) {
        int max = 1;
        for (int i = 1, pow = 1; i < s.length(); i++) {
            pow = (s.charAt(i) == s.charAt(i - 1)) ? pow + 1 : 1;
            max = Math.max(max, pow);
        }
        return max;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.maxPower("leetcode"));
        System.out.println(s.maxPower("abbcccddddeeeeedcba"));
        System.out.println(s.maxPower("triplepillooooow"));
        System.out.println(s.maxPower("hooraaaaaaaaaaay"));
        System.out.println(s.maxPower("tourist"));
    }
}

