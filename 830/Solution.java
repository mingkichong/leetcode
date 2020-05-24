import java.util.*;

class Solution {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> results = new ArrayList<>();
        int l = 0;
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(l) == S.charAt(i)) {
                count++;
            } else {
                if (count > 2) {
                    results.add(Arrays.asList(l, i - 1));
                }
                l = i;
                count = 1;
            }
        }
        if (S.charAt(l) == S.charAt(S.length() - 1) && count > 2) {
            results.add(Arrays.asList(l, S.length() - 1));
        }
        return results;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.largeGroupPositions("abbxxxxzzy"));
        System.out.println(s.largeGroupPositions("abc"));
        System.out.println(s.largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(s.largeGroupPositions("xxxxx"));
        System.out.println(s.largeGroupPositions("yxxxx"));
        System.out.println(s.largeGroupPositions("yxxxz"));
        System.out.println(s.largeGroupPositions("y"));
    }
}

