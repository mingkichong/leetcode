import java.util.*;

class Solution {
    public void rotate(int[][] matrix) {
        horizontalFlip(matrix);
        transpose(matrix);
    }

    void horizontalFlip(int [][] matrix){
        int l = 0, r = matrix.length - 1;
        while(l < r){
            int [] temp = matrix[l];
            matrix[l] = matrix[r];
            matrix[r] = temp;
            l++;r--;
        }
    }

    void transpose(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [][] matrix = {{5,1,9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        // int [][] matrix = {{0,1},{2,3}};
        s.rotate(matrix);
        for(int[] a : matrix){
            System.out.println(Arrays.toString(a));
        }
    }
}
