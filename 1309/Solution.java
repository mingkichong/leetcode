import java.util.*;

class Solution {

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        char [] c = s.toCharArray();
        for(int i = c.length - 1; i >= 0;){
            if(c[i] == '#'){
                sb.append((char)((c[i-2] - '0') * 10 + (c[i-1] - '0') - 1 + 'a'));
                i -= 3;
            } else {
                sb.append(((char)(c[i] - '0' - 1 + 'a')));
                i--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.freqAlphabets("10#11#12"));
        System.out.println(s.freqAlphabets("1326#"));
        System.out.println(s.freqAlphabets("25#"));
        System.out.println(s.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}

