import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j < s.length()+1; j++){
                if(isUnique(s, i, j)){
                    max = Math.max(max, j-i);
                }
            }
        }
        return max;
    }

    boolean isUnique(String s, int start, int end){
        Set<Character> set = new HashSet<Character>();
        for(int i = start; i < end; i++){
            set.add(s.charAt(i));
        }
        return set.size() == (end - start);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring(null));
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}
