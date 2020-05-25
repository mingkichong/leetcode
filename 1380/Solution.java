import java.util.*;

class Solution {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int [] rowMin = new int[matrix.length];
        for(int i = 0; i < rowMin.length; i++){
            rowMin[i] = Integer.MAX_VALUE;
        }
        int [] colMax = new int[matrix[0].length];
        for(int i = 0; i < colMax.length; i++){
            colMax[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.luckyNumbers(new int[][] {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
        System.out.println(s.luckyNumbers(new int[][] {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}}));
        System.out.println(s.luckyNumbers(new int[][] {{7, 8}, {1, 2}}));
    }
}
