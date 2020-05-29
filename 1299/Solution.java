import java.util.*;

class Solution {

    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = max;
            if (i > 0) {
                max = Math.max(max, current);
            }
        }
        arr[0] = max;
        return arr;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.replaceElements(new int[] {1})));
        System.out.println(Arrays.toString(s.replaceElements(new int[] {1, 2, 3})));
        System.out.println(Arrays.toString(s.replaceElements(new int[] {3, 2, 1})));
        System.out.println(Arrays.toString(s.replaceElements(new int[] {1, 1, 1})));
    }
}

