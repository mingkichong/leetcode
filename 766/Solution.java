import java.util.*;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length - 1; i++){
        	for(int j = 0; j < matrix[0].length - 1; j++){
        		if(matrix[i][j] != matrix[i+1][j+1]){
        			return false;
        		}
        	}
        }
        return true;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(
    		s.isToeplitzMatrix(
    			new int [][]{
    				{1,2,3,4},
    				{5,1,2,3},
    				{9,5,1,2}
    			}
    		)
    	);
    }
}