import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int projectionArea(int[][] grid) {
        final int N = grid.length;
        int top = 0, front = 0, side = 0;
        for(int i = 0; i < grid.length; i++){
            int maxFront = 0; int maxSide = 0;
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    top++;
                }
                maxFront = Math.max(maxFront, grid[i][j]);
                maxSide = Math.max(maxSide, grid[j][i]);
            }
            front += maxFront;
            side += maxSide;
        }
        return top + front + side;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int[][] grid = {{2,2,2},{2,1,2},{2,2,2}};
        if(Solution.RANDOM_INPUT){
            Random random = new Random();
            int N = random.nextInt(50) + 1;
            grid = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    grid[i][j] = random.nextInt(51);
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j]);
                System.out.print(" " + (grid[i][j] > 9 ? "" : " "));
            }
            System.out.println();
        }
        System.out.println(s.projectionArea(grid));
    }
}

