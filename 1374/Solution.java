import java.util.*;

class Solution {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        int count =  2 * (n - 1) / 2;
        for (int i = 0 ; i < count; i++) {
            sb.append("a");
        }
        sb.append(n % 2 == 0 ? "b" : "a");
        return sb.toString();
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        for (int i = 1; i < 100; i += 7) {
            String str = s.generateTheString(i);
            System.out.println(i + "\tlen: " + str.length() + "\t" + str);
        }
    }
}

