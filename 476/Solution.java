import java.util.*;

class Solution {
    public int findComplement(int num) {
        int mask = ~0;  // 1111 1111
        int n = num;
        while(n > 0){
            n /= 2;
            mask <<= 1; // right shift the number of bits in num
                        // 1111 1000
        }
        mask = ~mask;   // 0000 0111
        return mask ^ num; // xor to invert bits
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(Integer.toBinaryString(123) + " : " + Integer.toBinaryString(s.findComplement(123)));
    }
}