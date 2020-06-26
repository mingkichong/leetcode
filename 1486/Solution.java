import java.util.*;

class Solution {
    public int xorOperation(int n, int start) {
        int xor = start;
        for (int i = 1; i < n; i++) {
            start += 2;
            xor ^= (start);
        }
        return xor;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.xorOperation(5, 0));
        System.out.println(s.xorOperation(4, 3));
        System.out.println(s.xorOperation(1, 7));
        System.out.println(s.xorOperation(10, 5));
    }
}
