import java.util.*;

public class Solution {
    public String intToRoman(int num) {
        if(num < 1){
            return null;
        }

        StringBuffer sb = new StringBuffer();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1000, "M");
        map.put(900,  "CM");
        map.put(500,  "D");
        map.put(400,  "CD");
        map.put(100,  "C");
        map.put(90,   "XC");
        map.put(50,   "L");
        map.put(40,   "XL");
        map.put(10,   "X");
        map.put(9,    "IX");
        map.put(5,    "V");
        map.put(4,    "IV");
        map.put(1,    "I");

        ArrayList<Integer> keys = new ArrayList<Integer>();
        keys.addAll(map.keySet());
        Collections.sort(keys);
        Collections.reverse(keys);
        Integer[] values = keys.toArray(new Integer[keys.size()]);

        while(num > 0){
            for(int v :  values){
                if(num >= v){
                    sb.append(map.get(v));
                    num -= v;
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.intToRoman(1984));
    }
}