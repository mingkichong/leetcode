import java.util.*;

class Solution {
    HashMap<Character, String> map = new HashMap<Character, String>();
    void BuildMap(){
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<String>();
        if (digits.length() == 0){
            return queue;
        }
        
        BuildMap();

        queue.add("");
        for(int i = 0; i < digits.length(); i++){
            LinkedList<String> tempQ = new LinkedList<String>();
            while(queue.size() > 0){
                String qString = queue.poll();
                for(char a : map.get(digits.charAt(i)).toCharArray()){
                    tempQ.add(qString + a);
                }
            }
            queue = tempQ;
        }

        return queue;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.letterCombinations("239").toArray()));
    }
}