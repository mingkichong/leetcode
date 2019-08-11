import java.util.*;

class Solution {
    public boolean isNumber(String s) {
        if(s == null){
            return false;
        }
        s = s.trim();
        if(s.equals("")){
            return false;
        }

        if(isValidSign(s.charAt(0))){
            s = s.substring(1, s.length());
        }

        char prev = 0;
        char eCount = 0;
        for(char c : s.toCharArray()){
            if(prev == 'e' && isValidSign(c)){
                continue;
            }
            if(!isValid(c)){
                return false;
            }
            if(c == 'e'){
                eCount++;
            }
            prev = c;
        }

        if(eCount > 1){
            return false;
        }
        boolean hasE = eCount == 1;

        if(hasE){
            if(s.charAt(0) == 'e'){
                return false;
            }
            String [] baseExp = s.split("e");
            if(baseExp.length != 2){
                return false;
            }
            s = baseExp[0];
            String exp = baseExp[1];
            if(isValidSign(exp.charAt(0))){
                exp = exp.substring(1, exp.length());
            }
            if(exp.length() == 0){
                return false;
            }
            for(char c : exp.toCharArray()){
                if(!isDigit(c)){
                    return false;
                }
            }
        }

        if(!isValidDecimal(s)){
            return false;
        }

        return true;
    }

    boolean isValidDecimal(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '.'){
                count++;
            }
        }
        if(count > 1 || count == 1 && s.length() == 1){
            return false;
        }
        return true;
    }

    boolean isValidSign(char a){
        return a == '-' || a == '+';
    }

    boolean isValid(char c){
        switch(c){
            case '.':
            case 'e':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }

    boolean isDigit(char d){
        return (d - '0') >= 0 && (d - '0') <= 9;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String [] testcases = {
                    "0",
                    " 0.1 ",
                    "abc",
                    "1 a",
                    "2e10",
                    " -90e3   ",
                    " 1e",
                    "e3",
                    " 6e-1",
                    " 99e2.5 ",
                    "53.5e93",
                    " --6 ",
                    "-+3",
                    "95a54e53",
                    "1 e",
                    "0.0",
                    "1.0",
                    "",
                    "1a2",
                    "123e123e45",
                    "-123.45e13",
                    "123 e355",
                    ".1",
                    ".",
                    ".e1",
                    "4e+",
                    "4.e-4",
                    ".4e2",
                    "3.",
                    "4.e4",
                    "7e69e",
        };
        for(String str : testcases){
            System.out.println(str + getSpaces(str, 15) + "=>" + getSpaces("", 5) + s.isNumber(str));
        }
    }

    static String getSpaces(String str, int length){
        length -= str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
