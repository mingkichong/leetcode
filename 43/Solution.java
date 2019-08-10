import java.util.*;

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String nLong = (num1.length() > num2.length()) ? num1 : num2;
        String nShort = !(num1.length() > num2.length()) ? num1 : num2;
        String result = "0";
        for(int i = 0; i < nLong.length(); i++){
            result = add(result, appendZeroes( multiply(nShort, nLong.charAt(nLong.length() - 1 - i) - '0'), i));
        }

        return result;
    }

    String appendZeroes(String num, int N){
        StringBuilder sb = new StringBuilder(num);
        for(int i = 0; i < N; i++){
            sb.append("0");
        }
        return sb.toString();
    }

    String multiply(String num, int N){
        String result = "0";
        for(int i = 0; i < N; i++){
            result = add(num, result);
        }
        return result;
    }

    public String add(String num1, String num2){
        StringBuilder sb = new StringBuilder();

        num1 = reverse(num1);
        num2 = reverse(num2);

        int i = 0;
        int carryOver = 0;
        while(i < num1.length() && i < num2.length()){
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(i) - '0';
            int sum = n1 + n2 + carryOver;
            carryOver = sum / 10;
            sb.append(sum%10);
            i++;
        }
        if(i < num1.length()){
            while(i < num1.length()){
                int n1 = num1.charAt(i) - '0';
                int sum = n1 + carryOver;
                carryOver = sum / 10;
                sb.append(sum%10);
                i++;
            }
        }
        else if (i < num2.length()){
            while(i < num2.length()){
                int n2 = num2.charAt(i) - '0';
                int sum = n2 + carryOver;
                carryOver = sum / 10;
                sb.append(sum%10);
                i++;
            }
        }
        if(carryOver > 0){
            sb.append(carryOver);
        }

        return reverse(sb.toString());
    }

    String reverse(String n){
        return new StringBuilder(n).reverse().toString();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String num1 = "9999999999999999999999999999999999999999999999999999999999999999999", num2 = "999999999999999999999999999999999999";
        System.out.println(s.multiply(num1, num2));
    }
}
