import java.util.*;

class Solution {
    int diffCount = 0;
    public boolean validPalindrome(String str) {
        char[] s = str.toCharArray();
        int l = 0, r = s.length - 1;
        while (l < r) {
            if (s[l] == s[r]) {
                l++; r--;
            } else if (diffCount == 0) {
                diffCount = 1;
                return validPalindrome(str.substring(l, r)) || validPalindrome(str.substring(l + 1, r + 1));
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        // String testcase = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        // String testcase = "ebcbbececabbacecbbcbe";
        String testcase = "ababc";
        System.out.println(s.validPalindrome(testcase));
    }
}

