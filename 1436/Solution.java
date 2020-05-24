import java.util.*;

class Solution {

    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String city = paths.get(0).get(0);
        while (map.containsKey(city)) {
            city = map.get(city);
        }
        return city;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.destCity(pathStringsToLists(new String[][] {
            {"London", "New York"},
            {"New York", "Lima"},
            {"Lima", "Sao Paulo"}
        })));
        System.out.println(s.destCity(pathStringsToLists(new String[][] {{"B", "C"}, {"D", "B"}, {"C", "A"}})));
        System.out.println(s.destCity(pathStringsToLists(new String[][] {{"A", "Z"}})));
    }

    private static List<List<String>> pathStringsToLists(String [][] paths) {
        List<List<String>> results = new ArrayList<>();
        for (String[] path : paths) {
            results.add(Arrays.asList(path));
        }
        return results;
    }
}
