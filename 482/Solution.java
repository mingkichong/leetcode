import java.util.*;

class Solution {
	public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("[^a-zA-Z0-9]", "").toUpperCase(); //remove hyphens and change to uppercase
        int numGroups = S.length() / K;
        int remain = S.length() - (numGroups*K);

        char[] a = S.toCharArray();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        if(remain > 0){
            for(; i < remain; i++){
                ans.append(a[i]);
            }
            if(numGroups != 0){
                ans.append("-");
            }
        }
        
        for(int j = 0; j < numGroups; j++){
            for(int k = 0; k < K; k++){
                ans.append(a[i]);
                i++;
            }
            if(j != numGroups-1) ans.append("-");
        }
        return ans.toString();
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.licenseKeyFormatting("2-5g-3-J", 3));
    }
}