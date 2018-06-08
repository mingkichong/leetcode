import java.util.*;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0){
    		return "";
    	}
        Arrays.sort(strs, new Comparator<String>(){
        	@Override
        	public int compare(String a, String b){
        		return 
        			(a.length() == b.length()) ? 
        				0
        			: (a.length() < b.length()) ?
        				-1
        			:
        				1;
        	}
		});
        int length = strs[0].length();
        while(length > 0){
        	String sstr = strs[0].substring(0, length);
        	boolean isPrefix = true;
        	for(int i = 1; i < strs.length; i++){
        		if(sstr.compareTo(strs[i].substring(0, length)) != 0){
        			isPrefix = false;
        			break;
        		}
        	}
        	if(isPrefix){
        		return sstr;
        	}
        	else{
        		length--;
        	}
        }

        return "";
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.longestCommonPrefix(new String[]{"flower","flow","floight"}));
    }
}