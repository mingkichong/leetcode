import java.util.*;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2){
            return true;
        }
        int x1 = coordinates[0][0],
            y1 = coordinates[0][1],
            x2 = coordinates[1][0],
            y2 = coordinates[1][1];
        for(int [] xy : coordinates){
            int x = xy[0], y = xy[1];
            if( (x - x1) * (y - y2) != (x - x2) * (y - y1) ){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int[][] coordinates1 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates2 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(s.checkStraightLine(coordinates1));
        System.out.println(s.checkStraightLine(coordinates2));
    }
}
