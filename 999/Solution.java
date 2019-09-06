import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String __something() {
        return "SAMPLE";
    }

    public int numRookCaptures(char[][] board) {
        int numOfPawns = 0;
        int i = 0, j = 0;
        label:
        for(; i < board.length; i++){
            for(; j < board[0].length; j++){
                if(board[i][j] == 'R'){
                    // isFound = true;
                    break label;
                }
            }
            j = 0;
        }

        for(int a = i; a >= 0; a--){
            if(board[a][j] == 'p'){
                numOfPawns++;
                break;
            }
            if(board[a][j] == 'B'){
                break;
            }
        }
        for(int a = j; a >= 0; a--){
            if(board[i][a] == 'p'){
                numOfPawns++;
                break;
            }
            if(board[i][a] == 'B'){
                break;
            }
        }
        for(int a = i; a < board.length; a++){
            if(board[a][j] == 'p'){
                numOfPawns++;
                break;
            }
            if(board[a][j] == 'B'){
                break;
            }
        }
        for(int a = j; a < board.length; a++){
            if(board[i][a] == 'p'){
                numOfPawns++;
                break;
            }
            if(board[i][a] == 'B'){
                break;
            }
        }
        return numOfPawns;
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

