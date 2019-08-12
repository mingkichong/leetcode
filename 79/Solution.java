import java.util.*;

class Solution {
    public boolean exist(final char[][] board, final String word) {
        HashSet<String> set = new HashSet<String>();
        return exist(board, word, set);
    }

    public boolean exist(final char[][] board, final String word, HashSet<String> set) {
        final int R = board.length;
        if(R == 0){
            return false;
        }
        final int C = board[0].length;
        if(C == 0){
            return false;
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(traverse(board, i, j, word, "", set)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean traverse(final char[][] board, int r, int c, final String word, String prefix, HashSet<String> set){
        final int R = board.length;
        final int C = board[0].length;
        StringBuilder sb = new StringBuilder();
        sb.append(r);
        sb.append(",");
        sb.append(c);
        String key = sb.toString();
        if(set.contains(key)){
            return false;
        }
        set.add(key);
        sb.setLength(0);
        sb.append(prefix);
        sb.append(board[r][c]);
        prefix = sb.toString();

        if(!word.substring(0, prefix.length()).equals(prefix)){
            set.remove(key);
            return false;
        }
        if(prefix.equals(word)){
            return true;
        }
        if(prefix.length() == word.length()){
            set.remove(key);
            return false;
        }
        if(c+1 < C && traverse(board, r, c + 1, word, prefix, set)){
            return true;
        }
        if(c-1 >= 0 && traverse(board, r, c - 1, word, prefix, set)){
            return true;
        }
        if(r+1 < R && traverse(board, r + 1, c, word, prefix, set)){
            return true;
        }
        if(r-1 >= 0 && traverse(board, r - 1, c, word, prefix, set)){
            return true;
        }
        set.remove(key);
        return false;
    }

    public static void main(String args[]){
        Solution s = new Solution();

        Random random = new Random();
        int R = random.nextInt(10) + 10;
        int C = random.nextInt(10) + 10;
        System.out.println("Size: " + R + "x" + C);

        int wordLength;
        do{
            wordLength = random.nextInt(3) + 5;
        }while(wordLength > R*C);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < wordLength; i++){
            sb.append(getRandomChar(random));
        }
        String word = sb.toString();
        System.out.println("Word: " + word + "\n");

        char [][] board = null;
        HashSet<String> set = new HashSet<String>();
        boolean shouldExist = random.nextInt(2) == 1;
        if(!shouldExist){
            board = newBoard(R,C,random);
        }
        else{
            do{
                board = newBoard(R,C,random);
                set = new HashSet<String>();
            }while(!s.exist(board, word, set));
        }

    /*
        char [][] board = { {'b','a','a','b','a','b'},
                            {'a','b','a','a','a','a'},
                            {'a','b','a','a','a','b'},
                            {'a','b','a','b','b','a'},
                            {'a','a','b','b','a','b'},
                            {'a','a','b','b','b','a'},
                            {'a','a','b','a','a','b'}};
        // char[][] board = {{'A', 'A', 'B'}};
        String word = "aabbbbabbaababaaaabababbaaba";
        System.out.println(word);
    */

        print(board);
        System.out.println();
        if(shouldExist){
            print(board, set);
            System.out.println();
        }
        System.out.println(s.exist(board, word));
    }

    static char[][] newBoard(int R, int C, Random random){
        char [][] board = new char[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                board[i][j] = getRandomChar(random);
            }
        }
        return board;
    }

    static void print(char[][] board){
        print(board, new HashSet<String>());
    }

    static void print(char[][] board, HashSet<String> set){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                // String key = i + "," + j;
                if(set.size() > 0 && !set.contains(i + "," + j)){
                    System.out.print(".");
                }
                else{
                    System.out.print(board[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static char getRandomChar(Random random){
        return (char) (97 + random.nextInt(26));
    }
}
