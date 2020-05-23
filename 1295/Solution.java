import java.util.*;

class Solution {

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int n : nums){
            count += ("" + n).length() % 2 == 0 ? 1 : 0;
        }
        return count;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println(s.findNumbers(new int[]{555,901,482,1771}));
    }
}
