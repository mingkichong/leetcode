import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length-1;
        while(l < r){
            int w = r - l;
            int h = Math.min(height[l],height[r]);
            maxArea = Math.max(w*h, maxArea);
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{0}));
        System.out.println(s.maxArea(new int[]{0,1,0}));
        System.out.println(s.maxArea(new int[]{1}));
        System.out.println(s.maxArea(new int[]{}));
        System.out.println(s.maxArea(new int[]{1,18,17,6}));
        System.out.println(s.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
