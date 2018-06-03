import java.util.*;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	boolean[] bits = new boolean[32];
    	for(int i = 0; i < bits.length; i++){
    		bits[i] = (n % 2) == 1;
    		n >>= 1;
    	}
    	int ans = 0;
    	for(int i = 0; i < bits.length; i++){
    		ans <<= 1;
    		if(bits[i]){
				ans += 1;
			}
    	}
    	return ans;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.reverseBits(43261596));
    }
}