class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for(int i = 1; i < ans.length; i++){
            ans[i] = ans[i>>1] + (i&1);
        }
        return ans;
    }

    // public int[] countBits(int num) {
    //     int[] ans = new int[num + 1];
    //     for(int i = 0; i < ans.length; i++){
    //         ans[i] = getNumBits(i);
    //     }
    //     return ans;
    // }
    
    // public int getNumBits(int n){
    //     int count = 0;
    //     while(n > 0){
    //         if(n % 2 == 1){count++;}
    //         n/=2;
    //     }
    //     return count;
    // }
}