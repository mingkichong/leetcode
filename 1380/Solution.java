import java.util.*;

class Solution {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int [] rowMin = getRowMins(matrix);
        int [] colMax = getColMaxs(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }

    private int[] getRowMins(int[][] matrix) {
        int [] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = minRow(i, matrix);
        }
        return result;
    }

    private int[] getColMaxs(int[][] matrix) {
        int [] result = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            result[i] = maxCol(i, matrix);
        }
        return result;
    }

    private int minRow(final int ROW, int[][] matrix) {
        int min = matrix[ROW][0];
        for (int i = 1; i < matrix[0].length; i++) {
            min = Math.min(min, matrix[ROW][i]);
        }
        return min;
    }

    private int maxCol(final int COL, int[][] matrix) {
        int max = matrix[0][COL];
        for (int i = 1; i < matrix.length; i++) {
            max = Math.max(max, matrix[i][COL]);
        }
        return max;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.luckyNumbers(new int[][] {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
        System.out.println(s.luckyNumbers(new int[][] {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}}));
        System.out.println(s.luckyNumbers(new int[][] {{7, 8}, {1, 2}}));
    }
}
