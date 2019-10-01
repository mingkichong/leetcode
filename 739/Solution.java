import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int[] dailyTemperatures(int[] T) {
        int [] ans = new int[T.length];
        for(int i = 0; i < T.length-1; i++){
            for(int j = i+1; j < T.length; j++){
                if(T[i] < T[j]){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]){
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}

