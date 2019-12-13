import java.util.*;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        //https://en.wikipedia.org/wiki/Zeller%27s_congruence
        //https://www.geeksforgeeks.org/zellers-congruence-find-day-date/
        final String [] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        if(month < 3){
            month += 12;
            year--;
        }
        int q = day;
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = (q + 13*(m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        return daysOfWeek[h];
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int day = 31, month = 8, year = 2019;
        System.out.println(s.dayOfTheWeek(day, month, year));
        day = 18; month = 7; year = 1999;
        System.out.println(s.dayOfTheWeek(day, month, year));
        day = 15; month = 8; year = 1993;
        System.out.println(s.dayOfTheWeek(day, month, year));
    }
}

