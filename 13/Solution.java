import java.util.*;

class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0){
        	return 0;
        }

        HashMap <Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        for(int i = 0; i < s.length(); i++){
        	int value = map.get(s.charAt(i));
        	if(i < s.length() - 1){
        		int next = map.get(s.charAt(i+1));
        		if(value < next){
        			value = next - value;
        			i++;
        		}
        	}
        	total += value;
        }

        return total;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.romanToInt("MCMXCIV"));
    }
}