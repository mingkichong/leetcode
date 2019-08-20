import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; sb.length() < A.length() + B.length(); i++){
            sb.append(A);
            if(sb.toString().contains(B)){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String A = "aaaaaaaaaaaab", B = "ba";
        System.out.println(s.repeatedStringMatch(A,B));
    }
}

