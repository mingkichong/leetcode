import java.util.*;

class Solution {
    public String convertToBase7(int num) {
        if(num == 0){
            return "0";
        }

        boolean negative = (num < 0);
    	if(negative){
    		num *= -1;
    	}

    	StringBuilder sb = new StringBuilder();

    	while(num > 0){
    		int d = num % 7;
    		sb.append(d);
    		num /= 7;
    	}

    	if(negative){
    		sb.append('-');
    	}

        return sb.reverse().toString();
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.convertToBase7(-100));
    }
}