import java.util.*;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return wordBreakRightToLeft(s, set) || wordBreakLeftToRight(s, set);
    }

    private boolean wordBreakRightToLeft(String s, HashSet<String> set) {
        int l = s.length() - 1, r = s.length();
        while (l >= 0) {
            String subStr = s.substring(l, r);
            if (set.contains(subStr)) {
                r = l;
            }
            l--;
        }
        return r == 0;
    }

    private boolean wordBreakLeftToRight(String s, HashSet<String> set) {
        int l = 0;
        while (l < s.length()) {
            boolean exist = false;
            for (int r = s.length(); r > l; r--) {
                String subStr = s.substring(l, r);
                if (set.contains(subStr)) {
                    l = r;
                    exist = true;
                }
            }
            if (!exist) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.wordBreak("abcd", Arrays.asList(new String[] {"a", "abc", "b", "cd"})));
        System.out.println(s.wordBreak("aaaaaaa", Arrays.asList(new String[] {"aaa", "aaaa"})));
        System.out.println(s.wordBreak("leetcode", Arrays.asList(new String[] {"leet", "code"})));
        System.out.println(s.wordBreak("applepenapple", Arrays.asList(new String[] {"apple", "pen"})));
        System.out.println(s.wordBreak("catsandog", Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"})));
    }
}

