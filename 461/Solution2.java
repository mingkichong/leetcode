import java.util.Arrays;

class Solution {
    public int hammingDistance(int x, int y) {
    	int a = x ^ y;
    	int answer = 0;
    	for (int i = 0; i < 32; i++){
    		if( (a & (1 << i)) != 0){
    			answer++;
    		}
    	}
		return answer;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.hammingDistance(0,15));
    }
}