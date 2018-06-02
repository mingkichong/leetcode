import java.util.Arrays;

public class Solution2 {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        // k = nums.length-k; //left or right rotate
        k = (k % N);
        reverse(nums, 0, N-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, N-1);

    }

    public void reverse(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;r--;
        }
    }

    public static void main(String args[]){
    	Solution2 s = new Solution2();
    	int[] nums = {1,2,3,4,5,6};
    	int k = 1;
        System.out.println("k=" + k);
    	System.out.println(Arrays.toString(nums));
    	s.rotate(nums, k);
    	System.out.println(Arrays.toString(nums));
    }   
}