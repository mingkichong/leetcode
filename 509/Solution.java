import java.util.*;

class Solution {

/// time: O(n) space: O(1)
    public int fib(int N) {
        if(N < 1){
            return 0;
        }
        if(N == 1 || N == 2){
            return 1;
        }
        int fibN2 = 1, fibN1 = 1;
        int fibN = -1;
        for(int i = 3; i < N+1; i++){
            fibN = fibN2 + fibN1;
            fibN2 = fibN1;
            fibN1 = fibN;
        }
        return fibN;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int N = 30;
        System.out.println("fib(N" + N + "): " + s.fib(N));
    }
}
