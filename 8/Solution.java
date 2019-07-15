import java.util.*;

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(isEmptyString(str)){
            return 0;
        }
        if( !(isDigit(str.charAt(0)) || isValidSign(str.charAt(0))) ){
            return 0;
        }
        boolean isNegative = false;
        if(isValidSign(str.charAt(0))){
            isNegative = str.charAt(0) == '-';
            str = str.substring(1);
        }

        if(isEmptyString(str)){
            return 0;
        }

        if(!isDigit(str.charAt(0))){
            return 0;
        }

        while(str.length() > 0 && str.charAt(0) == '0'){
            str = str.substring(1);
        }

        if(isEmptyString(str)){
            return 0;
        }

        String validNumStr = "";
        for(int i = 0; i < str.length(); i++){
            if(isDigit(str.charAt(i))){
                validNumStr +=  str.charAt(i);
            }
            else{
                break;
            }
        }
        str = validNumStr;

        if(str.length() > 10){
            return (isNegative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        long num = 0;

        for(int i = 0; i < str.length(); i++){
            num *= 10;
            num += str.charAt(i) - '0';
        }

        if(isNegative){
            num *= -1;
        }

        if(num < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(num > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        return new Long(num).intValue();
    }

    private boolean isValidSign(char c){
        return c == '+' || c == '-';
    }

    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }

    private boolean isEmptyString(String s){
        return s.length() == 0;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String [] inputs = {"42", "   -42", "4193 with words", "words and 987", "-91283472332", "9223372036854775808", "  0000000000012345678", "    0000000000000   ", "-   234"};
        for(String a : inputs){
            System.out.println(s.myAtoi(a));
        }
    }
}
