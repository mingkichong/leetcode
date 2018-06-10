import java.util.*;

class Solution {
    public int calPoints(String[] ops) {
    	Stack<Integer> valid = new Stack<Integer>();
    	for(String op : ops){
    		if(op.compareTo("C") == 0){
    			if(!valid.empty()){
    				valid.pop();
    			}
    		}
    		else if(op.compareTo("D") == 0){
    			if(!valid.empty()){
    				valid.push( valid.peek() * 2 );
    			}
    		}
    		else if(op.compareTo("+") == 0){
    			int v1 = valid.pop();
    			int v2 = valid.pop();
    			valid.push(v2);
    			valid.push(v1);
    			valid.push(v1+v2);

    		}
    		else {
    			valid.push(Integer.parseInt(op));
    		}
    	}
    	int sum = 0;
    	while(!valid.empty()){
    		sum += valid.pop();
    	}
    	return sum;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}