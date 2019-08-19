import java.util.*;

class Solution {
/// time O(n^2) space O(1)
    public int removeDuplicates(int[] nums) {
        final int NUM_DUPLICATES = 2;
        if(nums == null){
            return 0;
        }
        final int N = nums.length;
        if(N == 0 || N == 1 || N == 2){
            return N;
        }

        int slow = 0, fast = 1;
        int nDup = 0; int length = N;
        while(fast < N && slow < length){
            while(fast < length && nums[slow] == nums[fast]){
                if(nDup < NUM_DUPLICATES - 1){
                    fast++;
                    slow++;
                    nDup++;
                }
                else{
                    shiftLeft(nums, fast, length);
                    length--;
                }
            }
            nDup = 0;
            fast++;
            slow++;
        }
        return length;
    }

    void shiftLeft(int[] nums, int index, int length){
        int temp = nums[index];
        for(int i = index; i < length - 1; i++){
            nums[i] = nums[i+1];
        }
        nums[length - 1] = temp;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
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

