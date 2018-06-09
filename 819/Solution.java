import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
    	paragraph = paragraph.toLowerCase();
        StringTokenizer st = new StringTokenizer(paragraph, "!?',;. ");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashSet<String> bannedSet = new HashSet<String>(Arrays.asList(banned));
        while(st.hasMoreElements()){
        	String s = st.nextToken();
        	if(!bannedSet.contains(s)){
        		map.put(s, ((map.containsKey(s)) ? map.get(s) : 0) + 1 );
        	}
        }
    	int maxCount = -1;
		String maxKey = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()){
			if(maxCount < entry.getValue()){
				maxCount = entry.getValue();
				maxKey = entry.getKey();
			}
		}
		return maxKey;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}