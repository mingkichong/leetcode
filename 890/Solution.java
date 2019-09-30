import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for(String word : words){
            if(isReplacable(word, pattern)){
                list.add(word);
            }
        }
        return list;
    }

    boolean isReplacable(String from, String to){
        if(from.length() != to.length()){
            return false;
        }
        int N = from.length();
        HashMap<Character, Character> fromToMap = new HashMap<>();
        HashSet<Character> toSet = new HashSet<>();
        for(int i = 0; i < N; i++){
            if(!fromToMap.containsKey(from.charAt(i)) && !toSet.contains(to.charAt(i))){
                fromToMap.put(from.charAt(i), to.charAt(i));
                toSet.add(to.charAt(i));
            }
            else{
                Character fromMapping = fromToMap.get(from.charAt(i));
                Character toMapping = to.charAt(i);
                if(fromMapping != toMapping){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        List<String> list = s.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "73k");
        System.out.println(list);
    }
}

