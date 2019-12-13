import java.util.*;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int [] total = new int[n];
        for(int[] booking : bookings){
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int seats = booking[2];
            for(int i = start; i <= end; i++){
                total[i] += seats;
            }
        }
        return total;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [][] bookings = new int[][]{{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        System.out.println(Arrays.toString(s.corpFlightBookings(bookings, n)));
    }
}

