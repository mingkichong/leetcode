import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return 0.0;
        }
        if(nums1 == null && nums2 != null || nums1 != null && nums2 == null ){
            int [] array = (nums1 != null) ? nums1 : nums2;
            int N = array.length;
            return (N % 2 == 0) ? ((double) array[N/2-1] + array[N/2]) / 2.0 
                                :  (double) array[N/2];
        }

        return getMedian(nums1, nums2);
    }

    //time O(m+n) where m = nums1.length, n = nums2.length space O(1)
    public double getMedian (int[] nums1, int[] nums2){
        int N = nums1.length + nums2.length;
        double median = 0.0, medianPrev = 0.0;

        int i = 0, n1 = 0, n2 = 0;
        for(; i <= (N/2) && n1 < nums1.length && n2 < nums2.length; i++){
            medianPrev = median;
            median = (nums1[n1] < nums2[n2]) ? nums1[n1++]
                                             : nums2[n2++];
        }
        if(i <= N/2){
            int [] array = (n1 < nums1.length) ? nums1 : nums2;
            int index = (n1 < nums1.length) ? n1 : n2;
            for(; i <= N/2; i++){
                medianPrev = median;
                median = array[index++];
            }
        }
        return (N % 2 == 0) ? (median + medianPrev)/2.0 : median;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums1 = new int[]{0, 1, 2};
        int [] nums2 = new int[]{3, 4, 5, 6, 7, 10};
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}
