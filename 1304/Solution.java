import java.util.*;

class Solution {

    public int[] sumZero(int n) {
        int start = n % 2 == 0 ? 1 : 0;
        int result [] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[i] = start;
                if (n % 2 == 1) start += 3;
            } else {
                result[i] = start * -1;
                if (n % 2 == 0) start += 3;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        for (int i = 1; i < 100; i += 7) {
            int [] array = s.sumZero(i);
            System.out.println("n: " + i + "\tsum: " + sum(array) + "\t" + Arrays.toString(array));
        }
    }

    private static int sum(int [] array) {
        int sum = 0;
        for (int a : array) {
            sum += a;
        }
        return sum;
    }
}

