import java.util.*;


class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char a : s.toCharArray()){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String a = "loveleetcode";
        System.out.println(a);
        int ans = s.firstUniqChar(a);
        for(int i = 0; i < ans; i++){
            System.out.print(" ");
        }
        System.out.println("^");
        System.out.println(ans);
    }
}

