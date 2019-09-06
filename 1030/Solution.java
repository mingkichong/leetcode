import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int [][] ans = new int[R*C][2];
        Cell[] cells = new Cell[R*C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                cells[i*C + j] = new Cell(i,j,r0,c0);
            }
        }
        Arrays.sort(cells);
        for(int i = 0; i < cells.length; i++){
            ans[i] = new int []{cells[i].x, cells[i].y};
        }
        return ans;
    }

    class Cell implements Comparable<Cell>{
        public int distance;
        public int x;
        public int y;

        public Cell(int x, int y, int r0, int c0){
            this.x = x;
            this.y = y;
            distance = Math.abs(r0 - x) + Math.abs(c0 - y);
        }

        public int compareTo(Cell o){
            return this.distance - o.distance;
        }

        public String toString(){
            return "(" + x + "," + y + ")";
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int R = 2, C = 3, r0 = 1, c0 = 2;
        System.out.println(Arrays.deepToString(s.allCellsDistOrder(R,C,r0,c0)));
    }
}


