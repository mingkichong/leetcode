import java.util.*;

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(char a : address.toCharArray()){
            if(a == '.'){
                sb.append("[.]");
            }
            else{
                sb.append(a);
            }
        }
        return sb.toString();
        // return address.replace(".", "[.]");
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.defangIPaddr("1.1.1.1"));
    }
}