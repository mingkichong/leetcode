import java.util.*;

class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for(char a : S.toCharArray()){
            if(!stack.empty() && a == ')' && stack.peek() == '('){
                stack.pop();
                continue;
            }
            stack.push(a);
        }
        return stack.size();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.minAddToMakeValid("()(())((()))())))"));
    }
}

