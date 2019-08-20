import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int[] diStringMatch(String S) {
        int [] A = new int[S.length()+1];
        int high = S.length();
        int low = 0;
        int i = 0;
        do{
            if(S.charAt(i) == 'I'){
                A[i] = low;
                low++;
            }
            else{
                A[i] = high;
                high--;
            }
            i++;
        }while(i < S.length());
        A[S.length()] = S.charAt(S.length() - 1) == 'I' ? low : high;
        return A;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String S = "DDI";
        if(Solution.RANDOM_INPUT){
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            int sLength = random.nextInt(50) + 5;
            for(int i = 0; i < sLength; i++){
                sb.append(random.nextBoolean() ? "I" : "D");
            }
            S = sb.toString();
        }
        System.out.println(S);
        System.out.println(Arrays.toString(s.diStringMatch(S)));
    }
}

