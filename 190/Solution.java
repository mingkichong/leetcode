import java.util.*;

public class Solution {

    public int reverseBits(int n) {
        int rN = 0;
        for(int i = 0; i < Integer.SIZE; i++){
            rN = rN << 1;
            rN += n & 1;
            n = n >> 1;
        }
        return rN;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
        int N = 43261596;
        System.out.println(padding(N));
    	System.out.println(padding(s.reverseBits(N)));
    }

    static String padding(int N){
        return String.format("%32s", Integer.toBinaryString(N)).replace(' ', '0');
    }
}