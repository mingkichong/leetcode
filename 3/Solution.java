import java.util.*;

class Solution {
    //time O(n), space O(n)
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, length = 0, start = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c)+1);
            }
            length = i - start + 1;
            max = Math.max(max, length);
            map.put(c, i);
        }
        return max;
    }

    // time O(n^3), space O(n) (because it uses isUnique)
    int test(String s){
        if(s == null){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < s.length(); i++){            //n,1
            for(int j = i + 1; j < s.length()+1; j++){  //n,1
                if(isUnique(s, i, j)){                  //n,n
                    max = Math.max(max, j-i);
                }
            }
        }
        return max;
    }

    // time O(n), space O(n)
    boolean isUnique(String s, int start, int end){
        Set<Character> set = new HashSet<Character>();
        for(int i = start; i < end; i++){
            set.add(s.charAt(i));
        }
        return set.size() == (end - start);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String [] inputs = new String[]{null, "", "z", "aa", "au", "abba", "dvdf", "abcdefghijklmnopqrstuvwyxz", "abcabcbb", "bbbbb", "pwwkew"};
        for(String str : inputs){
            int test = s.test(str);
            int ans = s.lengthOfLongestSubstring(str);
            System.out.println((test == ans) + "\t" + test + "\t" + ans + "\t: " + str);
        }
    }
}
