import java.util.*;

class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i+1]));
        }
        ArrayList<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i++){
            if(Math.abs(arr[i] - arr[i+1]) == minDiff){
                results.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return results;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] arr = {3,8,-10,23,19,-4,-14,27};
        System.out.println(s.minimumAbsDifference(arr));
    }
}

