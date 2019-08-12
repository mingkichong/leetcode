import java.util.*;

class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++){
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] A = {-16,-15,-9,-8,-4,-3,-1,0,2,5,6,7,19};
        // int [] A = {-16,-2, 0, 3, 4, 19};
        // int [] A = {-4, -3, 0, 2};
        System.out.println(Arrays.toString(s.sortedSquares(A)));
    }
}
