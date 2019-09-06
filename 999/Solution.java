import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    private int search(char [][] board, int x, int y, int dx, int dy){
        while(x < board.length && x >= 0 &&
              y < board.length && y >= 0 && board[x][y] != 'B'){
            if(board[x][y] == 'p'){
                return 1;
            }
            x += dx;
            y += dy;
        }
        return 0;
    }

    public int numRookCaptures(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'R'){
                    return search(board, i,j, 1, 0) +
                           search(board, i,j,-1, 0) +
                           search(board, i,j, 0, 1) +
                           search(board, i,j, 0,-1);
                }
            }
        }
        return 0;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        char[][] board = {{'.','.','.','.','.','.','.','.'},
                          {'.','.','.','p','.','.','.','.'},
                          {'.','.','.','p','.','.','.','.'},
                          {'p','p','.','R','.','p','B','.'},
                          {'.','.','.','.','.','.','.','.'},
                          {'.','.','.','B','.','.','.','.'},
                          {'.','.','.','p','.','.','.','.'},
                          {'.','.','.','.','.','.','.','.'}};
        System.out.println(s.numRookCaptures(board));
    }
}

