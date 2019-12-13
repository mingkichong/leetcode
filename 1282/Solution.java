import java.util.*;

class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++){
            if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i], new ArrayList<Integer>());
            }
            map.get(groupSizes[i]).add(i);
        }
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            int size = entry.getKey();
            if(list.size() <= size){
                results.add(list);
            }
            else{
                List<Integer> tempList = new ArrayList<>();
                for(int i = 0; i < list.size(); i++){
                    tempList.add(list.get(i));
                    if(tempList.size() == size){
                        results.add(tempList);
                        tempList = new ArrayList<>();
                    }
                }
                if(tempList.size() > 0){
                    results.add(tempList);
                }
            }
        }
        return results;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int[] groupSizes = new int[]{3,3,3,3,3,1,3};
        System.out.println(s.groupThePeople(groupSizes));
        groupSizes = new int[]{2,1,3,3,3,2};
        System.out.println(s.groupThePeople(groupSizes));
    }
}

