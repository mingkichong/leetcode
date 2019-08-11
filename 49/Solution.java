import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            String key = getKey(str);
            List<String> keyStrings = map.getOrDefault(key, new ArrayList<String>());
            keyStrings.add(str);
            map.put(key, keyStrings);
        }
        List<List<String>> results = new ArrayList<List<String>>();
        for(List<String> entry : map.values()){
            results.add(entry);
        }
        return results;
    }

    String getKey(String str){
        char [] a = str.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public static void main(String args[]){
        Solution s = new Solution();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = s.groupAnagrams(strs);
        if(groups == null){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(List<String> group : groups){
            for(String str : group){
                sb.append(str);
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString());
    }
}
