import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }
            else{
                map.put(i, 1);
            }
        }
        
        Map<Integer, Integer> sorted = map
            .entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(
                toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                LinkedHashMap::new));
        
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : sorted.entrySet()){
            if(i == k){
                break;
            }
            i++;
            list.add(entry.getKey());
        }
        
        return list;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {1,2,3,4,1,2,3,1,2,1};
        int k = 2;
        System.out.println(s.topKFrequent(nums, k).toString());
    }
}