import java.util.*;

class Solution {
    private final int BAD_VERSION;

    public Solution(int badVersion){
        this.BAD_VERSION = badVersion;
    }

    public int firstBadVersion(int n) {
        int l = 0, r = n-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(isBadVersion(mid+1)){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l+1;
    }

    public boolean isBadVersion(int version){
        return version >= BAD_VERSION;
    }

    public static void main(String args[]){
        int num = 4;
        Solution s = new Solution(num);
        for(int i = 1; i <= num; i++){
            System.out.println(s.firstBadVersion(i));
        }
    }
}
