import java.util.*;

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()){
            return false;
        }
        
        if(A.equals(B)){
            HashSet<Character> set = new HashSet();
            for(char c : A.toCharArray()){set.add(c);}
            return set.size() < A.length(); // at least one repeated character
        }
        
        int l = -1, r = -1;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) != B.charAt(i)){
                if(l < 0)      l = i;
                else if(r < 0) r = i;
                else           return false;
            }
        }

        if(l < 0 || r < 0){
            return false;
        }
        char[] achars = A.toCharArray();
        char temp = achars[l];
        achars[l] = achars[r];
        achars[r] = temp;
        if(new String(achars).equals(B)){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.buddyStrings("aaaaaaacb", "aaaaaaacb"));
    }
}