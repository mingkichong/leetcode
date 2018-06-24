import java.util.*;
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int sum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                sum += getMaxHeight(grid, i, j) - grid[i][j];
            }
        }
        return sum;
    }
    
    public int getMaxHeight(int[][] grid, int i, int j){
        int maxR = 0, maxC = 0;
        for(int a = 0; a < grid.length; a++){
            maxR = Math.max(grid[i][a], maxR);
            maxC = Math.max(grid[a][j], maxC);
        }
        return Math.min(maxR, maxC);
    }
}