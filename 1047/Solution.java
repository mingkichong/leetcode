import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String removeDuplicates(String S) {
        StringBuilder sb = null;
        do{
            if(sb != null){
                S = sb.toString();
            }
            sb = new StringBuilder();
            for(int i = 0; i < S.length(); i++){
                if(i == S.length() - 1){
                    sb.append(S.charAt(i));
                }
                else{
                    if(S.charAt(i) == S.charAt(i+1)){
                        i++;
                    }
                    else{
                        sb.append(S.charAt(i));
                    }
                }
            }
        } while(!S.equals(sb.toString()));
        return S;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.removeDuplicates("bbbaabbccb"));
    }
}

