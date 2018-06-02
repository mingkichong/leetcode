import java.util.HashSet;
import java.lang.StringBuilder;

class Solution {
	String translations [] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
    	HashSet<String> set = new HashSet<String>();
    	for(String w : words){
			StringBuilder sb = new StringBuilder();
    		for(int i = 0; i < w.length(); i++){
    			char c = w.charAt(i);
    			sb.append(translations[c - 97]);
    		}
    		String morseWord = sb.toString();
    		if(!set.contains(morseWord)){
    			set.add(morseWord);
    		}
    	}
    	return set.size();
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	String words [] = {"gin", "zen", "gig", "msg"};
    	int answer = s.uniqueMorseRepresentations(words);
    	System.out.println(answer);
    }
}