import java.util.*;

class Solution {
    public String reverseWords(String s) {
    	char[] a = s.toCharArray();
    	for(int i = 0; i < a.length; i++){
    		if(a[i] == ' '){
    			continue;
    		}
    		int end = i;
    		while(end + 1 < a.length && a[end+1] != ' '){
    			end++;
    		}
    		reverse(a, i, end);
    		i = end;
    	}

        // String[] words = s.split(" ");
        // for(int i = 0; i < words.length; i++){
        // 	words[i] = reverse(words[i]);
        // }
        // return String.join(" ", words);
        
        return new String(a);
    }

    public void reverse(char[] a, int start, int end){
    	int i = start;
    	int j = end;
    	while(i < j){
    		char temp = a[i];
    		a[i] = a[j];
    		a[j] = temp;
    		i++;j--;
    	}
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.reverseWords("Let's take LeetCode contest"));
    }
}