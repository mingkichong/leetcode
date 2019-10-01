import java.util.*;

class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return set.size() == map.values().size();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.uniqueOccurrences(new int[]{1,2,2,1,1,3})); //true
        System.out.println(s.uniqueOccurrences(new int[]{1,2})); //false
        System.out.println(s.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0})); //true
    }
}

