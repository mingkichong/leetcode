import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
    	paragraph = paragraph.toLowerCase();
        StringTokenizer st = new StringTokenizer(paragraph, "!?',;. ");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while(st.hasMoreElements()){
        	String s = st.nextToken();
        	boolean isBanned = false;
        	for(int i = 0; i < banned.length; i++){
        		if(s.compareTo(banned[i]) == 0){
        			isBanned = true;
        		}
        	}
        	if(!isBanned){
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