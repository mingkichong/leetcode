import java.util.*;

class Solution {
    public String countAndSay(final int N) {
        String nString = "1";
        for(int i = 0; i < N - 1; i++){
            nString = say(nString);
        }
        return nString;
    }

    private String say(String nString){
        StringBuilder sb = new StringBuilder();
        char [] n = nString.toCharArray();
        int i = 0;
        while(i < n.length){
            char a = n[i];
            int count = 1;
            while(i+1 < n.length && n[i] == n[i+1]){
                i++;
                count++;
            }
            sb.append(count);
            sb.append(a);
            i++;
        }
        return sb.toString();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.countAndSay(20));
    }
}
