import java.util.*;

class Solution {
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	for(char c : s.toCharArray()){
    		if( c == '(' || 
    			c == '{' ||
    			c == '['
    		){
    			stack.push(c);
    		}
    		else{
    			if(stack.empty()){
    				return false;
    			}
    			Character openBrack = stack.pop();
    			if( c == ')' && openBrack.charValue() != '(' ||
    				c == '}' && openBrack.charValue() != '{' ||
    				c == ']' && openBrack.charValue() != '['
    			){
    				return false;
    			}
    		}
    	}
    	if(stack.empty()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.isValid("(]"));
    }
}