import java.util.*;

class Solution {

    public int numIslands(char[][] map) {
        int numIslands = 0;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == '1'){
                    numIslands++;
                    paintVisited(map,i,j);
                }
            }
        }
        return numIslands;
    }

    public static void paintVisited(char [][] map, int i, int j){
        if(map[i][j] == '0'){
            return;
        }
        map[i][j] = '0';
        int R = map.length;
        int C = map[0].length;
        if(i - 1 >= 0){
            paintVisited(map, i - 1, j);
        }
        if(i + 1 < R){
            paintVisited(map, i + 1, j);
        }
        if(j - 1 >= 0){
            paintVisited(map, i, j - 1);
        }
        if(j + 1 < C){
            paintVisited(map, i, j + 1);
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String[] map = new String[]{"11110",
                                    "11010",
                                    "11000",
                                    "00011"};
        char [][] grid = new char[map.length][];
        for(int i = 0; i < grid.length; i++){
            grid[i] = map[i].toCharArray();
        }
        System.out.println(s.numIslands(grid));
    }
}
