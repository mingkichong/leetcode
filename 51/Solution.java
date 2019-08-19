import java.util.*;

class Solution {
    final char QUEEN = 'Q';
    public final int SIZE = 4;

    public List<List<String>> solveNQueens(int N) {
        if(N <= 3){
            return new ArrayList<List<String>>();
        }
        char [][] board = new char[N][N];


        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == 0){
                    board[i][j] = '.';
                }
            }
        }

        board[0][2] = QUEEN;
        board[1][0] = QUEEN;
        board[2][0] = QUEEN;

        // board[0][3] = 'Q';
        // board[2][1] = 'Q';

        // board[0][0] = 'Q';
        // board[1][2] = 'Q';
        // board[2][4] = 'Q';
        // board[3][1] = 'Q';
        // board[4][3] = 'Q';

        // board[0][1] = 'Q';
        // board[1][4] = 'Q';
        // board[2][2] = 'Q';
        // board[3][0] = 'Q';
        // board[4][3] = 'Q';

        // board[1][0] = QUEEN;
        // board[4][1] = QUEEN;
        // board[2][2] = QUEEN;
        // board[0][3] = QUEEN;
        // board[3][4] = QUEEN;



        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(isValid(board));

        return null;
    }

    boolean isValid(char[][] board){
        int N = board.length;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == QUEEN){
                    for(int r = 0; r < N; r++){
                        if(r != i && (board[r][j] == QUEEN)){
                            return false;
                        }
                    }
                    for(int c = 0; c < N; c++){
                        if(c != j && (board[i][c] == QUEEN)){
                            return false;
                        }
                    }
                    for(int d = 1; d < N; d++){
                        if( i-d >= 0 && j-d >= 0 && board[i-d][j-d] == QUEEN ||
                            i+d < N  && j+d < N  && board[i+d][j+d] == QUEEN ){
                            return false;
                        }
                        if( i-d >= 0 && j+d < N  && board[i-d][j+d] == QUEEN ||
                            i+d < N  && j-d >= 0 && board[i+d][j-d] == QUEEN
                            ){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    static void printBoards(List<List<String>> boards){
        System.out.println("[");
        for(List<String> board : boards){
            System.out.println(" [");
            for(String s : board){
                System.out.println("  \"" + s + "\"" + (board.lastIndexOf(s) != board.size() - 1 ? "," : ""));
            }
            System.out.println(" ]" + (boards.lastIndexOf(board) != boards.size() - 1 ? "," : ""));
        }
        System.out.println("]");
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();

        List<String> board = new ArrayList<String>();
        board.add(".Q..");
        board.add("...Q");
        board.add("Q...");
        board.add("..Q.");
        List<String> board2 = new ArrayList<String>();
        board2.add("..Q.");
        board2.add("Q...");
        board2.add("...Q");
        board2.add(".Q..");
        List<List<String>> boards = new ArrayList<List<String>>();
        boards.add(board);
        boards.add(board2);
        Solution.printBoards(boards);

        // List<List<String>> boards = s.solveNQueens(s.SIZE);
        // printBoards(boards);
    }
}

