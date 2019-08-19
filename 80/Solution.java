import java.util.*;

class Solution {
/// time O(n) space O(1)
    public int removeDuplicates(int[] nums) {
        final int NUM_DUPLICATES = 2;
        if(nums == null || nums.length == 0){
            return 0;
        }
        final int N = nums.length;
        int slow = 0, fast = 1;
        int nDup = 0;
        while(fast < N && slow < N){
            while(fast < N && nums[slow] == nums[fast]){
                if(nDup < NUM_DUPLICATES - 1){
                    slow++;
                    nums[slow] = nums[slow-1];
                    nDup++;
                }
                fast++;
            }
            if(fast < N && nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
            nDup = 0;
            fast++;
        }
        return slow + 1;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
        // int[]A = {1,2,2};
        int [] A = new int[random.nextInt(40) + 20];
        for(int i = 0; i < A.length; i++){
            A[i] = random.nextInt(10);
        }
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int N = s.removeDuplicates(A);
        print(A, N);

    }

    static void print(int [] A, int N){
        System.out.print("[");
        for(int i = 0; i < N; i++){
            System.out.print(A[i]);
            if(i < N-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

