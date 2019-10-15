import java.util.*;

class Solution {

    public int balancedStringSplit(String s) {
        int count = 0;
        int balance = 0;
        for(char a : s.toCharArray()){
            if(a == 'R'){
                balance++;
            }
            else if(a == 'L'){
                balance --;
            }
            if(balance == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.balancedStringSplit("RLLLLRRRLR"));
    }
}

