import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
    	List<Integer> sdNum = new ArrayList<Integer>();
    	for(int i = left; i <= right; i++){
    		if(isSelfDividingNumbers(i)){
    			sdNum.add(i);
    		}
    	}
        return sdNum;
    }

    public boolean isSelfDividingNumbers(int num){
    	int n = num;
    	while(n > 0){
    		int d = n % 10;
    		n /= 10;
    		if(d == 0 || (num % d) != 0){
    			return false;
    		}
    	}
    	return true;
    }

    public static void main (String args[]){
    	Solution s = new Solution();
    	System.out.println(Arrays.toString(s.selfDividingNumbers(1,10000).toArray()));
    }
}