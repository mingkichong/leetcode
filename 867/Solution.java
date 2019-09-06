import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int[][] transpose(int[][] A) {
        int C = A.length;
        int R = A[0].length;
        int[][] tranposed = new int[R][C];
        for(int i = 0; i < C; i++){
            for(int j = 0; j < R; j++){
                tranposed[j][i] = A[i][j];
            }
        }
        return tranposed;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [][] A = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(s.transpose(A)));
    }
}

