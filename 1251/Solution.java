import java.util.*;

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int [][] matrix = new int[n][m];
        for(int[] index : indices){
            int row = index[0];
            int col = index[1];
            for(int i = 0; i < matrix.length; i++){
                matrix[i][col]++;
            }
            for(int j = 0; j < matrix[0].length; j++){
                matrix[row][j]++;
            }
        }
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                count += matrix[i][j] % 2 > 0 ? 1 : 0;
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int n = 2;
        int m = 3;
        int [][] indices = new int[][]{{0,1},{1,1}};
        System.out.println(s.oddCells(n, m, indices));

        n = 2;
        m = 2;
        indices = new int[][]{{1,1},{0,0}};
        System.out.println(s.oddCells(n, m, indices));
    }
}

