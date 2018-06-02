import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<Character>();
        char[] jewels = J.toCharArray();
        for(char c : jewels){
        	set.add(c);
        }
        int count = 0;
        char[] stones = S.toCharArray();
        for(char c :  stones){
        	if(set.contains(c)){
        		count++;
        	}
        }
        return count;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	int answer = s.numJewelsInStones("aA","aAAbbbb");
    	System.out.println(answer);
    }
}
