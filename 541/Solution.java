import java.util.*;

class Solution {
    public String reverseStr(String s, int k) {
    	char[] a = s.toCharArray();

    	if(a.length < k){
    		reverse(a, 0, a.length-1);
    		return new String(a);
    	}
        for(int i = 0; i < a.length; i++){
        	if(i % 2 == 0){
        		reverse(a, i*k, i*k+k-1);
        	}
        }

        return new String(a);
    }

    public void reverse(char[] a, int start, int end){
    	int i = start;
    	int j = end;
    	if(a.length < j){
    		j = a.length-1;
    	}
    	while(i < j){
    		char temp = a[i];
    		a[i] = a[j];
    		a[j] = temp;
    		i++;j--;
    	}
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.reverseStr("abcdefg",2));
    }
}