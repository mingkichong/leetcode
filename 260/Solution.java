import java.util.*;

class Solution {

    public int[] singleNumber(int[] nums) {
        int [] results = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.contains(n)){
                set.remove(n);
            }
            else{
                set.add(n);
            }
        }
        int a = 0;
        for(Integer i : set){
            results[a++] = i;
            if(a == results.length){ break; } //not needed since we know there are only 2 unique numbers
        }
        return results;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.singleNumber(new int[]{1,2,1,3,2,5})));
    }
}

