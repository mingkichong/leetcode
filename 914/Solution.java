import java.util.*;

class Solution {

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> histo = new HashMap<>();
        for (int d : deck) {
            histo.put(d, histo.getOrDefault(d, 0) + 1);
        }
        int primes[] = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31}; // max length = 1000, so only need primes upto sqrt(1000)
        for (int prime : primes) {
            boolean hasCommon = true;
            for (int val : histo.values()) {
                if (val == 1) {
                    return false;
                }
                if (val % prime != 0) {
                    hasCommon = false;
                    break;
                }
            }
            if (hasCommon) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.hasGroupsSizeX(new int [] {1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(s.hasGroupsSizeX(new int [] {1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(s.hasGroupsSizeX(new int [] {1}));
        System.out.println(s.hasGroupsSizeX(new int [] {1, 1}));
        System.out.println(s.hasGroupsSizeX(new int [] {1, 1, 2, 2, 2, 2}));
        System.out.println(s.hasGroupsSizeX(new int [] {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}));
    }
}

