import java.util.*;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int [] people = new int[num_people];
        int i = 1,sum = 0;
        for(; sum + i < candies; i++){
            people[(i-1)%num_people] += i;
            sum += i;
        }
        if(sum < candies){
            people[(i-1)%num_people] += candies - sum;
        }
        return people;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.distributeCandies(7, 4)));
    }
}
