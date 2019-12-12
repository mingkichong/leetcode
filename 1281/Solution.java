import java.util.*;

class Solution {

    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            prod *= digit;
            sum += digit;
            n /= 10;
        }
        return prod - sum;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.subtractProductAndSum(234));
        System.out.println(s.subtractProductAndSum(4421));
        System.out.println(s.subtractProductAndSum(1));
        System.out.println(s.subtractProductAndSum(100000));
        System.out.println(s.subtractProductAndSum(99999));
        System.out.println(s.subtractProductAndSum(2));

    }
}

