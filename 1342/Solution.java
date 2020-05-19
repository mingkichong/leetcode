import java.util.*;

class Solution {

    public int numberOfSteps (int num) {
        int count = 0;
        while (num != 0) {
            count ++;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.numberOfSteps(14));
        System.out.println(s.numberOfSteps(8));
        System.out.println(s.numberOfSteps(123));
    }
}

