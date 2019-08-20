import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int minDeletionSize(String[] A) {
        int count = 0;
        for(int i = 0; i < A[0].length(); i++){
            for(int j = 0; j < A.length-1; j++){
                if(A[j].charAt(i) > A[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String [] A = {"zyx","wvu","tsr"};
        if(Solution.RANDOM_INPUT){
            Random random = new Random();
            int length = random.nextInt(50) + 5;
            int rows = random.nextInt(3) + 3;
            A = new String[rows];
            for(int i = 0; i < rows; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < length; j++){
                    sb.append((char) (random.nextInt(26) + 'a'));
                }
                A[i] = sb.toString();
            }
        }
        if(Solution.DEBUG){
            System.out.println("C:" + A[0].length());
        }
        print(A);
        System.out.println(s.minDeletionSize(A));
    }

    static void print(String[] A){
        for(String a : A){
            System.out.println(a);
        }
    }
}

