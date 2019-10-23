import java.util.*;

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum  = 0;
        for(int d : distance){
            sum += d;
        }
        if(destination < start){
            destination += distance.length;
        }
        int clockwise = 0;
        for(int i = start; i < destination; i++){
            clockwise += distance[i%distance.length];
        }
        int anticlockwise = sum - clockwise;
        return (clockwise < anticlockwise) ? clockwise : anticlockwise;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.distanceBetweenBusStops(new int[]{7,10,1,12,11,14,5,0}, 7, 2));
    }
}

