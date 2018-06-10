import java.util.*;

class Solution {
    public int countPrimeSetBits(int L, int R) {
    	int sum = 0;
        for(int i = L; i <= R; i++){
        	int bCount = Integer.bitCount(i);
        	if(isPrime(bCount)){
        		sum++;
        	}
        }
        return sum;
    }

    boolean isPrime(int n) {
    	if (n==1)   return false;
    	if (n==2)   return true;
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.countPrimeSetBits(244, 269));
    }
}