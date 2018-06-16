import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        return isIso(s,t) && isIso(t,s);
    }

    public boolean isIso(String s, String t){
    	if(s.length() != t.length()){
    		return false;
    	}
        HashMap<Character, Character> map_s_t = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
        	char s_c = s.charAt(i);
        	char t_c = t.charAt(i);
        	if(map_s_t.containsKey(s_c)){
        		char mapped_c = map_s_t.get(s_c);
        		if(mapped_c != t_c){
        			return false;
        		}
        	}
        	else{
        		map_s_t.put(s_c, t_c);
        	}
        }
        return true;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.isIsomorphic("abd", "abb"));
    }
}