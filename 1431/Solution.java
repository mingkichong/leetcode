import java.util.*;

class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<>();
        int max = candies[0];
        for(int i = 1; i < candies.length; i++){
            max = Math.max(max, candies[i]);
        }
        for(int candy : candies){
            result.add(candy + extraCandies >= max);
        }
        return result;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }
}

