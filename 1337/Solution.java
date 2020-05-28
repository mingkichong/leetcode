import java.util.*;

class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // can also use a TreeMap
        for (int i = 0; i < mat.length; i++) {
            int rowSum = sumRow(mat[i]);
            if (!map.containsKey(rowSum)) {
                map.put(rowSum, new ArrayList<>());
            }
            map.get(rowSum).add(i);
        }
        int [] result = new int[k];
        int i = 0;
        boolean isDone = false;
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        while (i < k) {
            for (int key : keys) {
                List<Integer> list = map.get(key);
                for (int n : list) {
                    result[i++] = n;
                    if (i == k) {
                        isDone = true;
                        break;
                    }
                }
                if (isDone) {
                    break;
                }
            }
        }

        return result;
    }

    private int sumRow(int [] array) {
        int sum = 0;
        for (int a : array) {
            sum += a;
        }
        return sum;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.kWeakestRows(new int[][] {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        }
        , 5)));

        System.out.println(Arrays.toString(s.kWeakestRows(new int[][] {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        }
        , 2)));
    }
}

