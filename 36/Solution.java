import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isSquareValid(board) && isStraightValid(board, true) && isStraightValid(board, false);
    }

    public boolean isSquareValid(char[][] board){
    	boolean isValid = true;
    	for(int i = 0; i < 3; i++){
    		for(int j = 0; j < 3; j++){
    			if(!isSquareValid(board, i, j)){
    				isValid = false;
    			}
    		}
    	}
    	return isValid;
    }

    public boolean isSquareValid(char[][] board, int hOffset, int vOffset){
    	HashSet<Character> set = new HashSet<Character>();
    	for(int i = 0 + hOffset*3; i < 3 + hOffset*3; i++){
    		for(int j = 0 + vOffset*3; j < 3 + vOffset*3; j++){
				char a = board[i][j];
				if(a == '.'){
    				continue;
    			}
    			if(set.contains(a)){
    				return false;
    			}
    			else{
    				set.add(a);
    			}
    		}
    	}
    	return true;
    }

    public boolean isStraightValid(char[][] board, boolean isH){
    	for(int i = 0; i < 9; i++){
    		HashSet<Character> set = new HashSet<Character>();
    		for(int j = 0; j < 9; j++){
    			char a = (isH) ? board[i][j] : board[j][i] ;
    			if(a == '.'){
    				continue;
    			}
    			if(set.contains(a)){
    				return false;
    			}
    			else{
    				set.add(a);
    			}
    		}
    	}
    	return true;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	char[][] board = new char[][]{
    		// {'5','3','.','.','7','.','.','.','.'},
			// {'6','.','.','1','9','5','.','.','.'},
			// {'.','9','8','.','.','.','.','6','.'},
			// {'8','.','.','.','6','.','.','.','3'},
			// {'4','.','.','8','.','3','.','.','1'},
			// {'7','.','.','.','2','.','.','.','6'},
			// {'.','6','.','.','.','.','2','8','.'},
			// {'.','.','.','4','1','9','.','.','5'},
			// {'.','.','.','.','8','.','.','7','9'}

			// {'8','3','.','.','7','.','.','.','.'},
			// {'6','.','.','1','9','5','.','.','.'},
			// {'.','9','8','.','.','.','.','6','.'},
			// {'8','.','.','.','6','.','.','.','3'},
			// {'4','.','.','8','.','3','.','.','1'},
			// {'7','.','.','.','2','.','.','.','6'},
			// {'.','6','.','.','.','.','2','8','.'},
			// {'.','.','.','4','1','9','.','.','5'},
			// {'.','.','.','.','8','.','.','7','9'}

			{'.','.','.','.','5','.','.','1','.'},
			{'.','4','.','3','.','.','.','.','.'},
			{'.','.','.','.','.','3','.','.','1'},
			{'8','.','.','.','.','.','.','2','.'},
			{'.','.','2','.','7','.','.','.','.'},
			{'.','1','5','.','.','.','.','.','.'},
			{'.','.','.','.','.','2','.','.','.'},
			{'.','2','.','9','.','.','.','.','.'},
			{'.','.','4','.','.','.','.','.','.'}
    	};
    	System.out.println(s.isValidSudoku(board));
    }
}