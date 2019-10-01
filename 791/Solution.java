import java.util.*;

class Solution {

    public String customSortString(String S, String T) {
        int [] map = new int[26];
        for(int i = 0; i < map.length; i++){
            map[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i) - 'a'] = i;
        }
        Character [] tArray = new Character[T.length()];
        for(int i = 0; i < tArray.length; i++){
            tArray[i] = T.charAt(i);
        }
        Arrays.sort(tArray, new Comparator<Character>(){
            public int compare(Character o1, Character o2){
                return map[o1 - 'a'] - map[o2 - 'a'];
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

