import java.util.*;

class Solution {
    //time O(n^2), space O(n)
    public String longestPalindrome(String s) {
        if(s == null){
            return null;
        }
        if(s.length() == 0 || s.length() == 1){
            return s;
        }

        String longestPalindromeString = "";
        for(int i = 0; i < s.length(); i++){
            longestPalindromeString = longestString(longestPalindromeString,
                                                    longestString(
                                                        longestPalindrome(s, i, i),
                                                        longestPalindrome(s, i, i+1)
                                                    ));
        }
        return longestPalindromeString;
    }

    String longestPalindrome(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }

    String longestString(String a, String b){
        return (a.length() >= b.length()) ? a : b;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String [] inputs = new String[]{"babad", "cbbd", "98765456543232", "", null};
        for(String str : inputs){
            System.out.println(s.longestPalindrome(str));
        }
    }
}
