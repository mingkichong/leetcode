class Solution {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }

        // for(int i = 0; i*i <= x; i++){
        //     if(i*i == x || i*i < x && (i+1)*(i+1) > x){
        //         return i;
        //     }
        // }
        // return -1;

        int l = 1, r = x;
        while (l <= r){
            int i = l + (r-l)/2;
            if(i == x/i || (i < x/i && (i+1) > x / (i+1))){
                return i;
            }
            if(i > x/i){
                r = i;
            }
            else{
                l = i+1;
            }
        }
        return -1;

    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.mySqrt(1));
    }
}