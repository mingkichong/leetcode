import java.util.Arrays;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
    	int[][] flipAndInvertA = new int [A.length][A[0].length];
    	for(int i = 0; i < flipAndInvertA.length; i++){
    		for(int j = 0; j < flipAndInvertA[i].length; j++){
    			flipAndInvertA[i][j] = A[i][flipAndInvertA[i].length - 1 - j];
    			flipAndInvertA[i][j] = (flipAndInvertA[i][j] == 1 ? 0 : 1);
    		}
    	}
        return flipAndInvertA;
    }

    public static void main (String args[]){
		Solution s = new Solution();
		// int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
		int[][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
    	System.out.println(Arrays.deepToString(s.flipAndInvertImage(A)));
    }
}