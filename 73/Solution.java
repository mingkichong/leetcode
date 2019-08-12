import java.util.*;

class Solution {

 ////////////////////////////////////////////////////////////////
    // space O(1) works with all integers
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        boolean isZeroRow = false;
        boolean isZeroCol = false;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        isZeroRow = true;
                    }
                    else{
                        matrix[i][0] = 0;
                    }
                    if(j == 0){
                        isZeroCol = true;
                    }
                    else{
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for(int j = 1; j < C; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < R; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < R; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < C; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(isZeroRow){
            for(int j = 0; j < C; j++){
                matrix[0][j] = 0;
            }
        }
        if(isZeroCol){
            for(int i = 0; i < R; i++){
                matrix[i][0] = 0;
            }
        }
    }
  ////////////////////////////////////////////////////////////////


  ////////////////////////////////////////////////////////////////
    // space O(1), it fails in test cases when the matrix has a value of Integer.MIN_VALUE
    // int ZEROED = Integer.MIN_VALUE;
    // public void setZeroes(int[][] matrix) {
    //     final int ROWS = matrix.length;
    //     final int COLS = matrix[0].length;
    //     for(int i = 0; i < ROWS; i++){
    //         for(int j = 0; j < COLS; j++){
    //             if(matrix[i][j] == 0){
    //                 setZeroes(matrix, i, j);
    //             }
    //         }
    //     }
    //     for(int i = 0; i < ROWS; i++){
    //         for(int j = 0; j < COLS; j++){
    //             if(matrix[i][j] == ZEROED){
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }

    // void setZeroes(int[][] matrix, int r, int c){
    //     for(int j = 0; j < matrix[0].length; j++){
    //         if(matrix[r][j] != 0){
    //             matrix[r][j] = ZEROED;
    //         }
    //     }
    //     for(int i = 0; i < matrix.length; i++){
    //         if(matrix[i][c] != 0){
    //             matrix[i][c] = ZEROED;
    //         }
    //     }
    // }
 ////////////////////////////////////////////////////////////////


 ////////////////////////////////////////////////////////////////
    // space O(m + n)
    // public void setZeroes(int[][] matrix) {
    //     boolean [] rows = new boolean[matrix.length];
    //     boolean [] cols = new boolean[matrix[0].length];
    //     for(int i = 0; i < rows.length; i++){
    //         for(int j = 0; j < cols.length; j++){
    //             if(matrix[i][j] == 0){
    //                 rows[i] = true;
    //                 cols[j] = true;
    //             }
    //         }
    //     }
    //     for(int i = 0; i < rows.length; i++){
    //         if(rows[i]){
    //             for(int j = 0; j < cols.length; j++){
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    //     for(int j = 0; j < cols.length; j++){
    //         if(cols[j]){
    //             for(int i = 0; i < rows.length; i++){
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }
 ////////////////////////////////////////////////////////////////

    public static void main(String args[]){
        Solution s = new Solution();
        // int [][] matrix = {{5,1,7,1}, {5,5,1,2}, {1,3,1,0}};
        // int [][] matrix = {{-1,1,2,1}};
        int [][] matrix = generate(3, 5);
        print(matrix);
        s.setZeroes(matrix);
        print(matrix);
    }

    static int [][] generate(int R, int C){
        int[][] matrix = new int[R][C];
        Random random = new Random();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                matrix[i][j] = random.nextInt(10) * ((random.nextInt() < 5) ? -1 : 1);
            }
        }
        return matrix;
    }

    static void print(int [][] matrix){
        for(int [] row : matrix){
            for(int c : row){
                System.out.print(fillSpaces(c)+ c);
            }
            System.out.println();
        }
        System.out.println();
    }

    static String fillSpaces(int d){
        return (d < 0) ? " " : "  ";
    }
}
