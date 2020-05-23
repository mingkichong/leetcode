import java.util.*;

class Solution {

    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i+=2){
            int freq = nums[i];
            int val = nums[i+1];
            for(int j = 0; j < freq; j++){
                result.add(val);
            }
        }
        return intListToArray(result);
    }

    private int[] intListToArray(List<Integer> list){
        final int N = list.size();
        int[] result = new int[N];
        for(int i = 0; i < N; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.decompressRLElist(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(s.decompressRLElist(new int[]{1,1,2,3})));
    }
}
