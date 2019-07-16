import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        list.add("");
        for(int i = 0; i < n; i++){
            HashSet<String> set = new HashSet<String>();
            for(String t : list){
                set.add("(" + t + ")");
                set.add("()" + t);
                set.add(t + "()");
            }
            list = new ArrayList<String>();
            list.addAll(set);
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        List<String> list = s.generateParenthesis(5);
        // for(String st : list){
        //     System.out.print(st + ":");
        //     System.out.println(isValidParenthesis(st));
        // }
        String [] output = {"((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())()())","((())())()","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())()()","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"};
        Arrays.sort(output);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i) + "==" + output[i] + "?" + list.get(i).equals(output[i]));
        }
    }

    /*
    static boolean isValidParenthesis(String s){
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
    */
}
