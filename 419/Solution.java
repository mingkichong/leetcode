import java.util.*;

class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    if(i > 0 && board[i-1][j] == 'X' || j > 0 && board[i][j-1] == 'X'){
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String [] stringBoard = {"X..X..",
                                 "...X.X",
                                 "...X.."};
        char [][] board = new char[stringBoard.length][];
        for(int i = 0; i < stringBoard.length; i++){
            board[i] = stringBoard[i].toCharArray();
        }
        System.out.println(s.countBattleships(board));
    }
}

