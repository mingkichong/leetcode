import java.util.*;

class Solution {

    public int[] sumZero(int n) {
        int num = n;
        int result [] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = num * (i % 2 == 0 ? 1 : -1);
            num += i % 2 == 0 ? 0 : n;
        }
        result[result.length - 1] = (n % 2 == 1) ? 0 : result[result.length - 1];
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

