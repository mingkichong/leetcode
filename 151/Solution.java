import java.util.*;

class Solution {
    public String reverseWords(String s) {
        if(isAllBlank(s)){
            return "";
        }
        char[] sArray = s.toCharArray();
        reverse(sArray, 0, sArray.length-1);
        int N = sArray.length;
        for(int i = 0; i < N; ){
            if(sArray[i] == ' '){
                int k = i;
                while(k < N && sArray[k] == ' '){
                    k++;
                }
                leftShift(sArray, i, k-i);
            }
            int j = i;
            while(j < N && sArray[j] != ' '){
                j++;
            }
            reverse(sArray, i, j-1);
            i = j+1;
        }
        int l = N-1;
        while(sArray[l] == ' '){
            l--;
        }
        return new String(sArray, 0, l+1);
    }

    public boolean isAllBlank(String s){
        for(char c : s.toCharArray()){
            if(c != ' ' && c != '\t' && c != '\n' && c != '\r'){
                return false;
            }
        }
        return true;
    }

    public void leftShift(char [] array, int s, int numPos){
        int f = s+numPos;
        for(; f < array.length; s++, f++){
            array[s] = array[f];
        }
        for(int i = 0; i < numPos; i++){
            array[array.length - numPos + i] = ' ';
        }
    }

    public void reverse(char [] array, int l, int r){
        while(l < r){
            char temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++; r--;
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String [] inputs = new String[]{"the sky is blue", "  hello  world! ", "a good   example "};
        for(String str : inputs){
            System.out.println(s.reverseWords(str));
        }
    }
}
