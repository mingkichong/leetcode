import java.util.*;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> dictionary = new HashSet<>();
        HashSet<String> results = new HashSet<>();
        int maxWordLength = 0;
        for(String s : words){
            dictionary.add(s);
            maxWordLength = Math.max(maxWordLength, s.length());
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                DFS(board, i, j, new HashSet<String>(), "", results, dictionary, maxWordLength);
            }
        }
        return new ArrayList<String>(results);
    }

    private void DFS(final char[][] board, int i, int j, HashSet<String> seenSet, String prefix, HashSet<String> results, final HashSet<String> dictionary, final int maxWordLength){
        prefix += board[i][j];
        if(prefix.length() > maxWordLength){
            return;
        }
        seenSet.add(i+","+j);
        if(dictionary.contains(prefix)){
            results.add(prefix);
        }
        if(i - 1 >= 0 && !seenSet.contains( (i-1) + "," + j )){
            DFS(board, i - 1, j, seenSet, prefix, results, dictionary, maxWordLength);
        }
        if(i + 1 < board.length && !seenSet.contains( (i+1) + "," + j )){
            DFS(board, i + 1, j, seenSet, prefix, results, dictionary, maxWordLength);
        }
        if(j - 1 >= 0 && !seenSet.contains( i + "," + (j-1) )){
            DFS(board, i, j - 1, seenSet, prefix, results, dictionary, maxWordLength);
        }
        if(j + 1 < board[0].length && !seenSet.contains( i + "," + (j+1) )){
            DFS(board, i, j + 1, seenSet, prefix, results, dictionary, maxWordLength);
        }
        seenSet.remove(i+","+j);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        char [][] board = {{'o','a','a','n'},
                           {'e','t','a','e'},
                           {'i','h','k','r'},
                           {'i','f','l','v'}};
        String [] words = {"oath","pea","eat","rain"};

        // char [][] board = {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},{'b','b','b','b','b','b'},{'a','a','a','b','a','a'},{'a','b','a','a','b','b'}};
        // String [] words = {"abbbababaa"};

        // char [][] board = {{'b','a','a','b','a','b'},
        //                    {'a','b','a','a','a','a'},
        //                    {'a','b','a','a','a','b'},
        //                    {'a','b','a','b','b','a'},
        //                    {'a','a','b','b','a','b'},
        //                    {'a','a','b','b','b','a'},
        //                    {'a','a','b','a','a','b'}};
        // String [] words = {"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};

        System.out.println(s.findWords(board, words));
    }
}

