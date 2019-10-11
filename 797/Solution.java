import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(!map.containsKey(graph[i][j])){
                    map.put(graph[i][j], new ArrayList<Integer>());
                }
                map.get(graph[i][j]).add(i);
            }
        }
        List<String> paths = new ArrayList<>();
        dfs(map, graph.length - 1, ""+(graph.length-1), paths);
        List<List<Integer>> results = new ArrayList<>();
        for(String path : paths){
            String [] pathNodes = path.split(",");
            if(pathNodes[0].equals("0")){
                ArrayList<Integer> validPath = new ArrayList<>();
                for(String node : pathNodes){
                    validPath.add(Integer.parseInt(node));
                }
                results.add(validPath);
            }
        }
        return results;
    }

    private void dfs(HashMap<Integer, List<Integer>> map, int destination, String currentPath, List<String> paths){
        List<Integer> list = map.get(destination);
        if(list != null){
            for(int i : list){
                dfs(map, i, "" + i + "," + currentPath, paths);
            }
        }
        paths.add(currentPath);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int[][] graph = new int [][]{{1,2}, {3}, {3}, {}};
        System.out.println(s.allPathsSourceTarget(graph));
    }
}

