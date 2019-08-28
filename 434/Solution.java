import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int countSegments(String s) {
        return new StringTokenizer(s).countTokens();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.countSegments("                 Hello,       my           name          is John            "));
    }
}

