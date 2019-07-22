import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> set = new HashSet<String>();
        String [] words = str.split(" ");
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
            }
            else{
                if(set.contains(words[i])){
                    return false;
                }
                map.put(pattern.charAt(i),words[i]);
                set.add(words[i]);
            }
        }
        return true;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.wordPattern("abba","dog cat cat dog"));    //true
        System.out.println(s.wordPattern("abba","dog cat cat fish"));   //false
        System.out.println(s.wordPattern("aaaa","dog cat cat dog"));    //false
        System.out.println(s.wordPattern("abba","dog dog dog dog"));    //false
    }
}
