import java.util.*;

class Solution {
     public int countPrimes(int n) {
        int count = 0;
        boolean [] sieve = sieveOfEratosthenesIsPrime(n);
        for(int i = 2; i < n; i++){
            if(sieve[i]){
                count++;
            }
        }
        return count;
    }
    
    /*
    public boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        if(n % 2 == 0){
        	return false;
        }
        for(int i = 3; i*i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    */

    public boolean [] sieveOfEratosthenesIsPrime (int n){
    	boolean [] isPrimeArray = new boolean[n];
    	for(int i = 2; i < isPrimeArray.length; i++){
    		isPrimeArray[i] = true;
    	}

    	for(int i = 2; i*i <= n; i++){
    		if(isPrimeArray[i]){
    			for(int j = i*i; j < n; j += i){
    				isPrimeArray[j] = false;
    			}
    		}
    	}
	    return isPrimeArray;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(s.countPrimes(Integer.MAX_VALUE/2));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
}