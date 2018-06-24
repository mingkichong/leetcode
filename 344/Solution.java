import java.util.*;

class Solution {
    public String reverseString(String s) {
        char[] a = s.toCharArray();
        int l = 0, r = a.length-1;
        while(l < r){
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++; r--;
        }
        return new String(a);
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.reverseString("helloworld"));
    }
}