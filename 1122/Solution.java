import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        for(int n : arr2){
            int count = map.get(n);
            for(int i = 0; i < count; i++){
                arr1[index + i] = n;
            }
            index += count;
            map.remove(n);
        }
        int sortStart = index;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            for(int i = 0; i < entry.getValue(); i++){
                arr1[index + i] = entry.getKey();
            }
            index += entry.getValue();
        }
        Arrays.sort(arr1, sortStart, arr1.length);
        return arr1;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int [] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(s.relativeSortArray(arr1, arr2)));
    }
}

