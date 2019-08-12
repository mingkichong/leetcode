import java.util.*;

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int l = 0;
        int r = A.length - 1;
        while(l < r){
            while(l < A.length && A[l] % 2 != 1){
                l++;
            }
            while(r >= 0 && A[r] % 2 != 0){
                r--;
            }
            if(l < r){
                swap(A, l, r);
            }
        }
        return A;
    }

    void swap(int [] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
        int [] A = new int[random.nextInt(30) + 5];
        for(int i = 0; i < A.length; i++){
            A[i] = random.nextInt(A.length) + 1;
        }
        System.out.println(Arrays.toString(s.sortArrayByParity(A)));
    }
}
