import java.util.*;

class Solution {
    public boolean hasAlternatingBits(int n) {
        
        /*
            1 0 1 0
            0 1 0 1
            1 1 1 1 
        */

        int t = n ^ (n >> 1);       // right shift n by 1, then xor n
        return (t & (t+1)) == 0;    // if all 1's, then it is alternating bits

        // int mask1 = 0, mask2 = 1;
        // int n_copy = n;
        // boolean flip = false;
        // while(n_copy > 0){
        //  mask1 <<= 1;
        //  mask1 += (flip) ? 0 : 1;
        //  mask2 <<= 1;
        //  mask2 += (flip) ? 1 : 0;
        //  flip = !flip;
        //  n_copy >>= 1;
        // }

        // return (n ^ mask1) == 0 || (n ^ mask2) == 0;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.hasAlternatingBits(5));
    }
}