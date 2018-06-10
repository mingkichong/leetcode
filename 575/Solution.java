import java.util.*;

class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int c : candies){
        	set.add(c);
        }
        if(set.size() < candies.length / 2){
        	return set.size();
        }
        else{
        	return candies.length / 2;
        }
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.distributeCandies(new int[]{1,1,2,3}));
    }
}