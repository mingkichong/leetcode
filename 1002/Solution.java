import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public List<String> commonChars(String[] A) {
        List<String> words = new ArrayList<>();
        final int NUM_CHARS = 26;
        int[] histo = new int[NUM_CHARS];
        for(int i = 0; i < NUM_CHARS; i++){
            histo[i] = Integer.MAX_VALUE;
        }
        for(String str : A){
            int [] currHisto = new int[NUM_CHARS];
            for(char a : str.toCharArray()){
                currHisto[a-'a']++;
            }
            for(int j = 0; j < NUM_CHARS; j++){
                histo[j] = Math.min(histo[j],currHisto[j]);
            }
        }
        for(int i = 0; i < NUM_CHARS; i++){
            for(int j = 0; j < histo[i]; j++){
                words.add(Character.toString((char)('a' + i)));
            }
        }
        return words;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        List<String> words = s.commonChars(new String[]{"bella","label","roller", "llll"});
        System.out.println(Arrays.toString(words.toArray()));
    }
}

