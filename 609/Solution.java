import java.util.*;

class Solution {

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String line : paths){
            String [] info = line.split(" ");
            String directory_path = info[0];
            for(int i = 1; i < info.length; i++){
                String [] fileInfo = info[i].replace('(', ' ').replace(')', ' ').split(" ");
                String file_name = fileInfo[0];
                String file_content = fileInfo[1];
                if(!map.containsKey(file_content)){
                    map.put(file_content, new ArrayList<String>());
                }
                map.get(file_content).add(directory_path + "/" + file_name);
            }
        }
        List<List<String>> results = new ArrayList<>();
        for(List<String> entry :  map.values()){
            if(entry.size() > 1){
                results.add(entry);
            }
        }
        return results;
    }

    public static void main(String args[]){
        Solution s = new Solution();

        String [] inputs = new String[]{
            "root/a 1.txt(abcd) 2.txt(efgh)",
            "root/c 3.txt(abcd)",
            "root/c/d 4.txt(efgh)",
            "root 4.txt(efgh)"};

        System.out.println(s.findDuplicate(inputs));
    }
}
