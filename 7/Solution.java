class Solution {
    public int reverse(int x) {
        boolean negative = false;
        int ans = 0;

        if (x < 0){
        	negative = true;
        	x *= -1;
        }

    	while(x > 0){
        	int d = x % 10;
        	x /= 10;
        	ans += d;
        	if (x > 0){
        		int old_ans = ans;
        		ans *= 10;
        		if(ans/10 != old_ans){ // check if overflow
        			return 0;
        		}
        	}
        }

        if(negative){
        	ans *= -1;
        }
        return ans;
    }

    public static void main(String args[]){
    	Solution s = new Solution();
    	int x = 123456789;
    	System.out.println(s.reverse(x));
    }
}
