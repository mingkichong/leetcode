import java.util.*;

class Solution {
    public void gameOfLife(int[][] board) {
        int [][] nextBoard = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int livingNeighbours = getLivingNeighbours(board,i,j);
                nextBoard[i][j] = livingNeighbours == 3 || board[i][j] == 1 && livingNeighbours == 2 ? 1 : 0;
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = nextBoard[i][j];
            }
        }
    }

    private int getLivingNeighbours(int[][] board, int i, int j){
        int count = 0;
        if(i - 1 >= 0 && board[i-1][j] == 1){
            count++;
        }
        if(i + 1 < board.length && board[i+1][j] == 1){
            count++;
        }
        if(j - 1 >= 0 && board[i][j-1] == 1){
            count++;
        }
        if(j + 1 < board[0].length && board[i][j+1] == 1){
            count++;
        }
        if(i - 1 >= 0 && j - 1 >= 0 && board[i-1][j-1] == 1){
            count++;
        }
        if(i + 1 < board.length && j - 1 >= 0 && board[i+1][j-1] == 1){
            count++;
        }
        if(i - 1 >= 0 && j + 1 < board[0].length && board[i-1][j+1] == 1){
            count++;
        }
        if(i + 1 < board.length && j + 1 < board[0].length && board[i+1][j+1] == 1){
            count++;
        }
        return count;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int[][] board = {{0,1,0},
                         {0,0,1},
                         {1,1,1},
                         {0,0,0}};
        s.gameOfLife(board);
        for(int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}

