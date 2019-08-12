import java.util.*;

class Solution {

//////////////////////////////////////////////////////////////
/// time: O(n) space: O(1)
    public int repeatedNTimes(int[] A) {
        int l = 0, r = A.length - 1;
        int prevL = Integer.MIN_VALUE, prevR = Integer.MIN_VALUE;
        while(l < r){
            if(A[l] == A[r]){
                return A[l];
            }
            if(A[l] == prevL || A[l] == prevR){
                return A[l];
            }
            if(A[r] == prevL || A[r] == prevR){
                return A[r];
            }
            prevL = A[l];
            prevR = A[r];
            l++;
            r--;
        }
        return Integer.MAX_VALUE;
    }
//////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////
/// time: O(n) space: O(n)
    // public int repeatedNTimes(int[] A) {
    //     HashSet<Integer> set = new HashSet<Integer>();
    //     for(int a : A){
    //         if(set.contains(a)){
    //             return a;
    //         }
    //         else{
    //             set.add(a);
    //         }
    //     }
    //     return Integer.MAX_VALUE;
    // }
//////////////////////////////////////////////////////////////

    public static void main(String args[]){
        Solution s = new Solution();
        int [] A = {1,2,3,3};
        System.out.println(s.repeatedNTimes(A));
    }
}
