import java.util.*;

class Solution {
	String[] keyboardRows = new String[]{"QWERTYUIOPqwertyuiop", "ASDFGHJKLasdfghjkl", "ZXCVBNMzxcvbnm"};

    public String[] findWords(String[] words) {
    	ArrayList<String> ans = new ArrayList<String>();
    	for(String word : words){
    		for(String row : keyboardRows){
    			if(isWordInRow(word, row)){
    				ans.add(word);
    			}
    		}
    	}
        return ans.toArray(new String[ans.size()]);
    }

    public boolean isWordInRow(String w, String row){
    	boolean isFound = true;
    	for(char c : w.toCharArray()){
    		if(row.indexOf(c) == -1){
    			isFound = false;
    			break;
    		}
		}
    	return isFound;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(Arrays.toString(s.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}