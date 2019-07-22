import java.util.*;

class Solution {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        final int NUM_DIGITS = 10;
        int [] secretFreq = new int[NUM_DIGITS];
        int [] guessFreq = new int[NUM_DIGITS];

        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                A++;
            }
            else{
                secretFreq[secret.charAt(i) - '0']++;
                guessFreq[guess.charAt(i) - '0']++;
            }
        }
        for(int i = 0; i < NUM_DIGITS; i++){
            B += Math.min(secretFreq[i], guessFreq[i]);
        }

        return A + "A" + B + "B";
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String secret = "1078";
        String guess = "8071";
        System.out.println(secret);
        System.out.println(guess);
        System.out.println(s.getHint(secret, guess));
    }
}
