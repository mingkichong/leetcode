import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public List<String> commonChars(String[] A) {
        List<String> words = new ArrayList<>();
        int [][] histo = new int[A.length][26];
        for(int i = 0; i < A.length; i++){
            for(char a : A[i].toCharArray()){
                histo[i][a - 'a']++;
            }
        }
        for(int j = 0; j < 26; j++){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < A.length; i++){
                min = Math.min(min, histo[i][j]);
            }
            for(int k = 0; k < min; k++){
                words.add("" + (char)(j + 'a'));
            }
        }
        return words;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        List<String> words = s.commonChars(new String[]{"cool","lock","cook"});
        System.out.println(Arrays.toString(words.toArray()));
    }
}

