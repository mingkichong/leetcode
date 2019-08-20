import java.util.*;

class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        if(text == null){
            return null;
        }
        String [] words = text.split(" ");
        List<String> thirds = new ArrayList<String>();
        for(int i = 0; i < words.length-2; i++){
            if(words[i].equals(first) && words[i+1].equals(second)){
                thirds.add(words[i+2]);
            }
        }
        return thirds.toArray(new String[thirds.size()]);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String text = "alice is a good girl she is a good student";
        String first = "is";
        String second = "is";
        System.out.println(Arrays.toString(s.findOcurrences(text, first, second)));
    }
}

