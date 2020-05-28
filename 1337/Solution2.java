import java.util.*;

class Solution2 {

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Strength> strengths = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            strengths.add(new Strength(i, sumRow(mat[i])));
        }
        Collections.sort(strengths);
        int [] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = strengths.get(i).index;
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

    class Strength implements Comparable<Strength> {
        int index;
        int strength;
        Strength(int index, int strength) {
            this.index = index;
            this.strength = strength;
        }

        @Override
        public int compareTo(Strength o) {
            if (this.strength == o.strength) {
                return this.index - o.index;
            }
            return this.strength - o.strength;
        }
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
        , 3)));

        System.out.println(Arrays.toString(s.kWeakestRows(new int[][] {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        }
        , 2)));
    }
}

