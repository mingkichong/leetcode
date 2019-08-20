import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String reverseVowels(String s) {
        char [] A = s.toCharArray();
        int l = 0, r = A.length-1;
        while(l<r){
            while(l < r && !isVowel(A[l])){
                l++;
            }
            while(l < r && !isVowel(A[r])){
                r--;
            }
            char temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++; r--;
        }
        return new String(A);
    }

    boolean isVowel(char a){
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ||
               a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U';
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String str = "leetcode";
        System.out.println(s.reverseVowels(str));
    }
}

