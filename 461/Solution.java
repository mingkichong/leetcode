import java.util.Arrays;

class Solution {
    public int hammingDistance(int x, int y) {
    	boolean xbit, ybit;
        int answer = 0;
		for(int i = 0; i < 32; i++){
			xbit = (x & (1 << i)) != 0;
			ybit = (y & (1 << i)) != 0;
			if(xbit != ybit){
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