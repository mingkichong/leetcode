import java.util.*;

class Solution {
    public int[] sortedSquares(int[] A) {
        int min = Integer.MAX_VALUE;
        int m = -1;
        for(int i = 0; i < A.length; i++){
            A[i] *= A[i];
            if(A[i] < min){
                min = A[i];
                m = i;
            }
        }
        int l = 0, r = A.length - 1, ls = 0;
        System.out.println(Arrays.toString(A) + "\tLS:" + A[ls] + ", L:" + A[l] + ", M:" + A[m] + ", R:" + A[r] + " START");
        while(l < r){
            if(A[l] > A[r]){
                swap(A, l, r);
                System.out.println(Arrays.toString(A) + "\tLS:" + A[ls] + ", L:" + A[l] + ", M:" + A[m] + ", R:" + A[r] + " SWAP l r");
                l++;
                System.out.println(Arrays.toString(A) + "\tLS:" + A[ls] + ", L:" + A[l] + ", M:" + A[m] + ", R:" + A[r] + " L+1");
            }

            r--;
            System.out.println(Arrays.toString(A) + "\tLS:" + A[ls] + ", L:" + A[l] + ", M:" + A[m] + ", R:" + A[r] + " R-1");

            if(r == m){
                swap(A, ls, m);
                System.out.println(Arrays.toString(A) + "\tLS:" + A[ls] + ", L:" + A[l] + ", M:" + A[m] + ", R:" + A[r] + " SWAP ls m");
                ls++;
                System.out.println(Arrays.toString(A) + "\tLS:" + A[ls] + ", L:" + A[l] + ", M:" + A[m] + ", R:" + A[r] + " LS + 1");
                l = ls;
                r = A.length - 1;
                System.out.println(Arrays.toString(A) + "\tLS:" + A[ls] + ", L:" + A[l] + ", M:" + A[m] + ", R:" + A[r] + " L = LS R = len");
                while(m > 0 && A[m-1] < A[m]){
                    m--;
                    System.out.println(Arrays.toString(A) + "\tLS:" + A[ls] + ", L:" + A[l] + ", M:" + A[m] + ", R:" + A[r] + " MOVE m");
                }
            }
        }
        return A;
    }

    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        // int [] A = {-16,-15,-9,-8,-4,-3,-1,0,2,5,6,7,19};
        int [] A = {-16,-2, 0, 3, 4, 19};
        // int [] A = {-4, -3, 0, 2};
        System.out.println(Arrays.toString(s.sortedSquares(A)));
    }
}
