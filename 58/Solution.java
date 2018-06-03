class Solution {
    public int lengthOfLastWord(String s) {
        int sum = 0;
        s = s.trim();
        for(int i = s.length() -1; i >= 0; i--){
        	if(s.charAt(i) == ' '){
        		return sum;
        	}
        	else{
        		sum++;
        	}
        }
        return sum;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	String input = "Hello World";
    	System.out.println(s.lengthOfLastWord(input));
    }
}