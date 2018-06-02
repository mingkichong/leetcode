class Solution {
    public boolean judgeCircle(String moves) {
    	int vCount = 0;
    	int hCount = 0;
    	char m [] = moves.toCharArray();
    	for(char c : m){
    		switch(c){
    			case 'U':
    				vCount++;
    				break;
    			case 'D':
    				vCount--;
    				break;
    			case 'L':
    				hCount--;
    				break;
    			case 'R':
    				hCount++;
    				break;
    		}
    	}
    	return vCount == 0 && hCount == 0;    
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.judgeCircle("UDLR"));
    }
}