import java.util.*;

class Solution {

    public int maximum69Number (int num) {
        char[] numStr = Integer.toString(num).toCharArray();
        for (int i = 0; i < numStr.length; i++) {
            if (numStr[i] == '6') {
                numStr[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(numStr));
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.maximum69Number(9669));
        System.out.println(s.maximum69Number(9996));
        System.out.println(s.maximum69Number(9999));
    }
}
