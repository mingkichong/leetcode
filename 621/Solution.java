import java.util.*;

class Solution {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int [] hist = new int [26];
        int max = 0;
        for (char a : tasks) {
            hist[a - 'A']++;
            max = Math.max(max, hist[a - 'A']);
        }
        int countMax = 0;
        for (int m : hist) {
            countMax += m == max ? 1 : 0;
        }
        int num = max + (max - 1) * n + countMax - 1;
        return (num < tasks.length) ? tasks.length : num;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 0));
        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A'}, 2));
        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 1));
    }
}

