import java.util.*;

class Solution {
    public boolean backspaceCompare(String S, String T) {
		return getBackspaced(S).compareTo(getBackspaced(T)) == 0;  
    }

    public String getBackspaced(String S){
    	Stack<Character> stack = new Stack();
    	for(char s : S.toCharArray()){
    		if(s == '#' && !stack.empty()){
    			stack.pop();
    		}
    		else if (s != '#') {
    			stack.push(s);
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	while(!stack.empty()){
    		sb.append(stack.pop());
    	}
    	return sb.reverse().toString();
    }

    public static void main(String [] args){
    	Solution s = new Solution();
    	System.out.println(s.backspaceCompare("a##c","#a#c"));
    }
}