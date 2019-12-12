import java.util.*;

class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for(int i = 0; i < k; i++){
            grid = shift(grid);
        }
        return twoDArrayToList(grid);
    }

    private int[][] shift(int[][] grid){
        int [][] _grid = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length - 1; j++){
                _grid[i][j+1] = grid[i][j];
            }
        }
        for(int i = 1; i < grid.length; i++){
            _grid[i][0] = grid[i-1][grid[0].length - 1];
        }
        _grid[0][0] = grid[grid.length-1][grid[0].length-1];
        return _grid;
    }

    public List<List<Integer>>twoDArrayToList(int[][] twoDArray) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int[] array : twoDArray) {
            List<Integer> subList = new ArrayList<>();
            for(int i : array){
                subList.add(i);
            }
            list.add(subList);
        }
        return list;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int[][] grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        System.out.println(s.shiftGrid(grid, k));

        grid = new int[][]{{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        k = 4;
        System.out.println(s.shiftGrid(grid, k));

        grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        k = 9;
        System.out.println(s.shiftGrid(grid, k));
    }
}

