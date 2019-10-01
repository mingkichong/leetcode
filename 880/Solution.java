import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String decodeAtIndex(String S, int K) {
        if(S == null || S.length() == 0){
            return null;
        }
        String buffer = "";
        for(char a : S.toCharArray()){
            if(isDigit(a)){
                String tempBuffer = buffer;
                for(int i = 0; i < a-'0'-1; i++){
                    buffer += tempBuffer;
                    if(buffer.length() >= K){
                        return buffer.substring(K-1,K);
                    }
                }
            }
            else{
                buffer += a;
                if(buffer.length() >= K){
                    return buffer.substring(K-1,K);
                }
            }
        }
        while(buffer.length() < K){
            buffer += buffer;
        }
        return buffer.substring(K-1,K);
    }

    private boolean isDigit(char a){
        return a >= '0' && a <= '9';
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.decodeAtIndex("y959q969u3hb22odq595", 222280369));
    }
}
