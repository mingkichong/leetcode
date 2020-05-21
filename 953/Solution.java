import java.util.*;

class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }
        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int minLength = Math.min(word1.length(), word2.length());
            boolean checkLength = true;
            for(int j = 0; j < minLength; j++){
                if(map.get(word1.charAt(j)) < map.get(word2.charAt(j))){
                    checkLength = false;
                    break;
                }
                else if(map.get(word1.charAt(j)) > map.get(word2.charAt(j))){
                    return false;
                }
            }
            if(checkLength && word1.length() > word2.length()){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(s.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(s.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}

