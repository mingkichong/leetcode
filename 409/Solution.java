import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        int [] histo = new int[128];
        int count = 0;
        for(char a : s.toCharArray()){
            histo[a]++;
            if(histo[a] == 2){
                count += 2;
                histo[a] = 0;
            }
        }
        for(int h : histo){
            if(h > 0){
                count++;
                break;
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("abccccdd"));
    }
}

