import java.util.*;

class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(char a : str.toCharArray()){
            if(a >= 'A' && a <= 'Z'){
                sb.append((char)('a' - 'A'+ a));
            }
            else{
                sb.append(a);
            }
        }
        return sb.toString();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.toLowerCase("AbCdEfGHiJ"));
    }
}