import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public TreeNode recoverFromPreorder(String S) {
        List<Integer> nums = new ArrayList<Integer>();
        List<String> dashes = new ArrayList<String>();
        char [] A = S.toCharArray();
        int start = 0; int startDash = 0;
        char prevC = '-';
        for(int i = 0; i < S.length(); i++){
            if(isNum(A[i])){
                if(isDash(prevC)){
                    dashes.add(S.substring(startDash, i));
                    start = i;
                }
            }
            else if(isDash(A[i])){
                if(isNum(prevC)){
                    nums.add(Integer.parseInt(S.substring(start, i)));
                    startDash = i;
                }
            }
            prevC = A[i];
        }
        nums.add(Integer.parseInt(S.substring(start, S.length())));

        for(int i = 0; i < nums.size(); i++){
            System.out.println(dashes.get(i).length() + " " + nums.get(i));
        }
        return null;
    }

    private boolean isDash(char c){
        return c == '-';
    }

    private boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String S = "1-401--349---90--88";
        System.out.println(s.recoverFromPreorder(S));
    }
}

