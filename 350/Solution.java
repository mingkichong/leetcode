import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums2){
            Integer n = map.get(i);
            if(n != null && n > 0){
                list.add(i);
                map.put(i, n-1);
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums1 = new int[]{1,2,3,4,5,5,4,3,6,7,8,5,7,7,6};
        int [] nums2 = new int[]{9,7,8,0,5,6,4,7,8,6,5,9};
        System.out.println(Arrays.toString(s.intersect(nums1, nums2)));
    }
}
