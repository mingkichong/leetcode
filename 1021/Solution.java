import java.util.*;

class Solution {
    public String removeOuterParentheses(String S) {
        if(S == null){
            return null;
        }
        char [] A = S.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> outputStack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for(char a : A){
            if(a == '('){
                if(!stack.empty()){
                    outputStack.push('(');
                }
                stack.push('(');
            }
            else{
                stack.pop();
                if(!stack.empty()){
                    outputStack.push(')');
                }
            }
        }
        while(!outputStack.empty()){
            sb.append(outputStack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.removeOuterParentheses("()()"));
    }
}
