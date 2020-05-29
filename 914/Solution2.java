import java.util.*;

class Solution2 {

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> histo = new HashMap<>();
        for (int d : deck) {
            histo.put(d, histo.getOrDefault(d, 0) + 1);
        }
        int gcd = Integer.MAX_VALUE;
        for (int val : histo.values()) {
            gcd = Math.min(val, gcd);
        }
        if (gcd == 1) {
            return false;
        }
        for (; gcd > 1; gcd--) {
            boolean isCommonDivisor = true;
            for (int val : histo.values()) {
                if (val % gcd != 0) {
                    isCommonDivisor = false;
                    break;
                }
            }
            if (isCommonDivisor) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Solution2 s = new Solution2();
        System.out.println(s.hasGroupsSizeX(new int [] {1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(s.hasGroupsSizeX(new int [] {1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(s.hasGroupsSizeX(new int [] {1}));
        System.out.println(s.hasGroupsSizeX(new int [] {1, 2, 3}));
        System.out.println(s.hasGroupsSizeX(new int [] {1, 1}));
        System.out.println(s.hasGroupsSizeX(new int [] {1, 1, 2, 2, 2, 2}));
        System.out.println(s.hasGroupsSizeX(new int [] {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}));
    }
}

