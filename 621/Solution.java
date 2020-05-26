import java.util.*;

class Solution {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        HashMap<Character, Integer> hist = new HashMap<>();
        int max = 0;
        for (char a : tasks) {
            hist.put(a, hist.getOrDefault(a, 0) + 1);
            max = Math.max(max, hist.get(a));
        }
        int countMax = 0;
        for (int m : hist.values()) {
            countMax += m == max ? 1 : 0;
        }
        int num = max + (max - 1) * n + countMax - 1;
        return (num < tasks.length) ? tasks.length : num;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 8
        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 0)); // 6
        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A'}, 2)); // 7
        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 1)); // 11
    }
}

