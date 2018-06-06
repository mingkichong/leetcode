import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return answers;
        }

        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i = 0; i < nums.length-2; i++){
            int r = nums.length - 1;
            int l = i + 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    List<Integer> answer = new ArrayList<Integer>();
                    answer.add(nums[i]);
                    answer.add(nums[l]);
                    answer.add(nums[r]);
                    if(!set.contains(answer)){
                        set.add(answer);
                        answers.add(answer);
                    }
                    int prevR = nums[r];while(r > 0 && prevR == nums[r]){r--;}
                    int prevL = nums[l];while(l < nums.length && prevL == nums[l]){l++;}
                }else if(nums[r] + nums[l] + nums[i] > 0){
                    int prevR = nums[r];while(r > 0 && prevR == nums[r]){r--;}
                }
                else{
                    int prevL = nums[l];while(l < nums.length && prevL == nums[l]){l++;}
                }
            }
        }

        // for(int i = 0; i < nums.length-2; i++){
        //     for(int j = i+1; j < nums.length-1; j++){
        //         for(int k = j+1; k < nums.length; k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 List<Integer> answer = new ArrayList<Integer>();
        //                 answer.add(nums[i]);
        //                 answer.add(nums[j]);
        //                 answer.add(nums[k]);
        //                 Collections.sort(answer);
        //                 if(!set.contains(answer)){
        //                     set.add(answer);
        //                     answers.add(answer);
        //                 }
        //             }
        //         }
        //     }
        // }
        return answers;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int[] nums = new int[]{-1,0,1,2};
        System.out.println(Arrays.deepToString(s.threeSum(nums).toArray()));
    }
}