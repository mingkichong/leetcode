import java.util.*;

class Solution {
    public int[] sortedSquares(int[] A) {
        int min = Integer.MAX_VALUE;
        int minI = -1;
        for(int i = 0; i < A.length; i++){
            A[i] *= A[i];
            if(A[i] < min){
                min = A[i];
                minI = i;
            }
        }
        int [] B = new int[A.length];
        int bI = 0;
        int l = minI - 1;
        int r = minI;

        while(l >= 0 && r < A.length){
            B[bI++] = A[(A[l] < A[r]) ? l--: r++];
            // if(A[l] < A[r]){
            //     B[bI] = A[l];
            //     l--;
            // }
            // else{
            //     B[bI] = A[r];
            //     r++;
            // }
            // bI++;
        }

        while(l >= 0){
            B[bI++] = A[l--];
            // B[bI] = A[l];
            // bI++; l--;
        }
        while(r < A.length){
            B[bI++] = A[r++];
            // B[bI] = A[r];
            // bI++; r++;
        }

        return B;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] A = {-16,-15,-9,-8,-4,-3,-1,0,2,5,6,7,19};
        // int [] A = {-16,-2, 0, 3, 4, 19};
        // int [] A = {-4, -3, 0, 2};
        System.out.println(Arrays.toString(s.sortedSquares(A)));
    }
}
