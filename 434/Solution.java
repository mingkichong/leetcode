import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int countSegments(String s) {
        int count = 0;
        int slow = 0, fast = 0;
        char[] sArr = s.toCharArray();
        for(;slow < sArr.length && fast < sArr.length;){
            if(sArr[slow] == ' '){
                slow++;
                fast = slow;
            }
            else{
                count++;
                while(fast < sArr.length && sArr[fast] != ' '){
                    fast++;
                }
                slow = fast;
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.countSegments("                 Hello,       my           name          is John            "));
    }
}

