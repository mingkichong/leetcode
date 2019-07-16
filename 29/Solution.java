import java.util.*;

class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 1){
            return dividend;
        }
        if(dividend == divisor){
            return 1;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(divisor == Integer.MIN_VALUE){
            return 0;
        }

        boolean isDividendNegative = dividend < 0;
        boolean isDivisorNegative = divisor < 0;
        int ans = 0;

        if(dividend == Integer.MIN_VALUE){
            divisor = (isDivisorNegative ? 1 : -1) * divisor;
            while(dividend <= divisor){
                ans++;
                dividend += absolute(divisor);
            }
        }
        else{
            dividend = absolute(dividend);
            divisor = absolute(divisor);
            while(dividend >= divisor){
                ans++;
                dividend -= divisor;
            }
        }
        ans *= (!isDividendNegative && isDivisorNegative || isDividendNegative && !isDivisorNegative)? -1 : 1;
        return ans;
    }

    int absolute(int num){
        return num *= (num < 0) ? -1 : 1;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.divide(4, 3));
        System.out.println(s.divide(-4, 3));
        System.out.println(s.divide(4, -3));
        System.out.println(s.divide(-4, -3));

        long dd = Integer.MAX_VALUE;
        System.out.println(s.divide(Integer.MAX_VALUE, 1)  + "\t:\t" + dd/1);
        System.out.println(s.divide(Integer.MAX_VALUE, -1) + "\t:\t" + dd/-1);
        System.out.println(s.divide(Integer.MAX_VALUE, 2)  + "\t:\t" + dd/2);
        System.out.println(s.divide(Integer.MAX_VALUE, -2) + "\t:\t" + dd/-2);

        dd = Integer.MIN_VALUE;
        System.out.println(s.divide(Integer.MIN_VALUE, 1)  + "\t:\t" + dd/1);
        System.out.println(s.divide(Integer.MIN_VALUE, -1) + "\t:\t" + dd/-1);
        System.out.println(s.divide(Integer.MIN_VALUE, 2)  + "\t:\t" + dd/2);
        System.out.println(s.divide(Integer.MIN_VALUE, -2) + "\t:\t" + dd/-2);

        dd = Integer.MIN_VALUE;
        long dr = Integer.MAX_VALUE;
        System.out.println(s.divide(Integer.MIN_VALUE, Integer.MAX_VALUE) + "\t:\t" + dd/dr);

        dd = Integer.MAX_VALUE;
        dr = Integer.MIN_VALUE;
        System.out.println(s.divide(Integer.MAX_VALUE, Integer.MIN_VALUE)  + "\t:\t" + dd/dr);
    }
}
