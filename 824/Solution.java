import java.util.*;

class Solution {
    public String toGoatLatin(String S) {
        StringTokenizer st = new StringTokenizer(S);
        String[] words = new String[st.countTokens()];
        for(int i = 0; i < words.length; i++){
        	words[i] = st.nextToken();

        	if( isVowel(words[i].charAt(0)) ){
        		words[i] += "ma";
        	}
        	else{
        		words[i] = words[i].substring(1) + words[i].charAt(0) + "ma";
        	}

        	for(int j = 0; j < i+1; j++){
        		words[i] += "a";
        	}
        }

        return String.join(" ", words);
    }

    public boolean isVowel(char c){
    	return 	c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
    			c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.toGoatLatin("I speak Goat Latin"));
    }
}