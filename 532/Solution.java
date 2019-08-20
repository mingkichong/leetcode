import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || k < 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(k == 0){
                if(entry.getValue() > 1){
                    count++;
                }
            }
            else{
                if(map.containsKey(entry.getKey() + k)){
                    count++;
                }
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
