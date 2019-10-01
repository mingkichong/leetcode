import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String decodeAtIndex(String S, int k) {
        if(S == null || S.length() == 0){
            return null;
        }
        long decodedLen = 0;
        for(char a : S.toCharArray()){
            if(isDigit(a)){
                decodedLen *= a - '0';
            }
            else{
                decodedLen++;
            }
        }
        long K = k;
        for(char a : new StringBuilder(S).reverse().toString().toCharArray()){
            if(isDigit(a)){
                decodedLen /= a-'0';
                K = K % decodedLen;
            }
            else{
                if(K % decodedLen == 0){
                    return "" + a;
                }
                decodedLen--;
            }
        }
        return "";
    }

    private boolean isDigit(char a){
        return a >= '0' && a <= '9';
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.decodeAtIndex("leet2c12345", 36));
        System.out.println(s.decodeAtIndex("y959q969u3hb22odq595", 222280369));
    }
}
