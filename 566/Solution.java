import java.util.*;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length == 0){
            return nums;
        }
        int n_r = nums.length;
        int n_c = nums[0].length;
        if(n_r * n_c != r * c){
            return nums;
        }

        int t[] = new int[n_r*n_c];
        for(int i = 0; i < n_r; i++){
            for(int j = 0; j < n_c; j++){
                t[i*n_c + j] = nums[i][j];
            }
        }
        int ans[][] = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                ans[i][j] = t[i * c + j];
            }
        }

        // LinkedList<Integer> queue = new LinkedList<>();
        // for(int i = 0; i < n_r; i++){
        //     for(int j = 0; j < n_c; j++){
        //         queue.add(nums[i][j]);
        //     }
        // }
        // int ans[][] = new int[r][c];
        // for(int i = 0; i < r; i++){
        //     for(int j = 0; j < c; j++){
        //         ans[i][j] = queue.remove();
        //     }
        // }

        // int ans[][] = new int[r][c];
        // int ri = 0, cj = 0;
        // for(int i = 0; i < n_r; i++){
        //     for(int j = 0; j < n_c; j++){
        //         ans[ri][cj] = nums[i][j];
        //         cj++;
        //         if(cj == c){
        //             cj = 0;
        //             ri++;
        //         }
        //     }
        // }

        return ans;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.matrixReshape( new int[][]{{1,2},{3,4}},1,4)));
        System.out.println(Arrays.deepToString(s.matrixReshape( new int[][]{{1,2},{3,4},{5,6}},6,1)));
        System.out.println(Arrays.deepToString(s.matrixReshape( new int[][]{{1,2,3},{4,5,6},{7,8,9}},9,1)));
    }
}