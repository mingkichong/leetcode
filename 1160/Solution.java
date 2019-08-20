import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int countCharacters(String[] words, String chars) {
        int count = 0;
        int [] charsHistogram = getHistogram(chars);
        for(String w : words){
            count += (canForm(charsHistogram, getHistogram(w))) ? w.length() : 0;
        }
        return count;
    }

    int [] getHistogram(String word){
        int [] histogram = new int[26];
        for(char a : word.toCharArray()){
            histogram[a - 'a']++;
        }
        return histogram;
    }

    boolean canForm(int[] chars, int[] word){
        if(chars.length != word.length){
            return false;
        }
        for(int i = 0; i < chars.length; i++){
            if(chars[i] < word[i]){
                return false;
            }
        }
        return true;
    }

    static String getRandomWord(Random random){
        StringBuilder sb = new StringBuilder();
        int wordLength = random.nextInt(10) + 5;
        for(int i = 0; i < wordLength; i++){
            sb.append((char)(random.nextInt(26) + 'a'));
        }
        return sb.toString();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String[] words = {"cat","bt","hat","tree"};
        String chars = "zptqxvw";
        if(Solution.RANDOM_INPUT){
            Random random = new Random();
            words = new String[random.nextInt(16) + 5];
            for(int i = 0; i < words.length; i++){
                words[i] = getRandomWord(random);
            }
            chars = getRandomWord(random);
            int rounds = random.nextInt(5) + 1;
            for(int i = 0; i < rounds; i++){
                chars += getRandomWord(random);
            }

        }
        if(Solution.DEBUG){
            System.out.println(Arrays.toString(words));
            System.out.println(chars);
        }
        System.out.println(s.countCharacters(words, chars));
    }
}

