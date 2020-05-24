import java.util.*;

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int j = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count += grid[i].length - j;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.countNegatives(new int[][] {
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            { -1, -1, -2, -3}
        }));
        System.out.println(s.countNegatives(new int[][] {
            {3, 2},
            {1, 0}
        }));
        System.out.println(s.countNegatives(new int[][] {
            {1, -1},
            { -1, -1}
        }));
        System.out.println(s.countNegatives(new int[][] {
            { -1}
        }));
    }
}
