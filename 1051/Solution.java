import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int heightChecker(int[] H) {
        int count = 0;
        int [] H2 = Arrays.copyOf(H, H.length);
        Arrays.sort(H2);
        for(int i = 0; i < H.length; i++){
            if(H[i] != H2[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] H = new int[]{1,1,4,2,1,3};
        System.out.println(Arrays.toString(H));
        System.out.println(s.heightChecker(H));
    }
}

