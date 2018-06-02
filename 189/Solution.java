import java.util.Arrays;

public class Solution {
    public void rotate(int[] nums, int k) {
    	int N = nums.length;
    	if(N == 0 || k%N == 0){
    		return;
    	}
    	int [] newNums = new int[N];
    	for(int i = 0; i < N; i++){
    		newNums[i] = nums[ (i+N-(k%N))%N ];
    	}
		System.arraycopy(newNums, 0, nums, 0, N);
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	int[] nums = {1,2,3,4,5};
    	int k = 2;
    	System.out.println(Arrays.toString(nums));
    	s.rotate(nums, k);
    	System.out.println(Arrays.toString(nums));
    }   
}