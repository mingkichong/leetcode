import java.util.*;

class Solution {

    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            map.put(S.charAt(i), i);
        }
        Character [] tArray = new Character[T.length()];
        for(int i = 0; i < tArray.length; i++){
            tArray[i] = T.charAt(i);
        }
        Arrays.sort(tArray, new Comparator<Character>(){
            public int compare(Character o1, Character o2){
                return map.getOrDefault(o1, Integer.MAX_VALUE) - map.getOrDefault(o2, Integer.MAX_VALUE);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Character a : tArray){
            sb.append(a);
        }
        return sb.toString();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.customSortString("za", "asfdgsdbserhsdfcdefgergdgadsgfdsfhijklmnogbrikjnejfswgnoepqrstuvwxyz"));
    }
}

