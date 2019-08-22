import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int[] sortArrayByParityII(int[] A) {
        if(A.length < 2){
            return A;
        }
        int l = 0, r = 1;
        while(l < A.length && r < A.length){
            while(l < A.length && A[l] % 2 == 0){
                l+=2;
            }
            while(r < A.length && A[r] % 2 == 1){
                r+=2;
            }
            if(l < A.length && r < A.length){
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
            }
        }
        return A;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] A = {2,4,5,6,8,10,7,1,3,9};
        if(Solution.RANDOM_INPUT){
            Random random = new Random();
            int len = random.nextInt(40) + 21;
            len = toEven(len);
            A = new int[len];
            int [] odds = new int[len/2];
            int [] evens = new int[len/2];
            int i = 0;
            for(; i < len/2; i++){
                odds[i]  = toOdd (random.nextInt(100) + 1);
                evens[i] = toEven(random.nextInt(100) + 1);
            }
            int o = 0, e = 0;
            for(i = 0; o < len/2 && e < len/2; i++){
                A[i] = random.nextBoolean() ? odds[o++] : evens[e++];
            }
            for(; i < len; i++){
                if(o < len/2){
                    A[i] = odds[o++];
                }
                if(e < len/2){
                    A[i] = evens[e++];
                }
            }
        }
        System.out.println(Arrays.toString(s.sortArrayByParityII(A)));
    }

    static int toEven(int n){
        return n + (n % 2 == 0 ? 0 : 1);
    }

    static int toOdd(int n){
        return n + (n % 2 == 1 ? 0 : 1);
    }
}

