import java.util.*;

class Solution {

    public boolean isUgly(int num) {
        if(num < 1){
            return false;
        }
        int [] primes = new int[]{2,3,5};

        for(int i = 0; i < primes.length; i++){
            int prime = primes[i];
            while(num % prime == 0){
                num /= prime;
            }
        }

        return num == 1;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
        int nums = random.nextInt(50) + 10;
        for(int i = 0; i < nums; i++){
            int num = random.nextInt(100) + 1;
            System.out.println(num + ": " + s.isUgly(num));
        }
    }
}
