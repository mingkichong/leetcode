import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || k < 0){
            return 0;
        }
        int duplicates = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums){
            int value = map.getOrDefault(n, 0) + 1;
            map.put(n, value);
        }
        for(int value : map.values()){
            if(value > 1){
                duplicates++;
            }
        }
        if(k == 0){
            return duplicates;
        }
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        int count = 0;
        for(int i : list){
            if(map.containsKey(i-k) && i-k != i){
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) throws Exception{
        Solution s = new Solution();
        Scanner scanner = new Scanner(new FileInputStream("testcase.txt"));
        String [] numsStrings = scanner.nextLine().split(",");
        int [] nums = new int [numsStrings.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(numsStrings[i]);
        }
        int k = Integer.parseInt(scanner.nextLine());
        // int [] nums = {1,1,1,1,1,1};
        // int k = 0;
        System.out.println(s.findPairs(nums, k));
    }
}
