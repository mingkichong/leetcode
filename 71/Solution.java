import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        if(path == null){
            return null;
        }
        String [] pathSplit = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String p : pathSplit){
            if(!p.equals("") && !p.equals(".")){
                if(p.equals("..")){
                    if(!stack.empty()){
                        stack.pop();
                    }
                }
                else{
                    stack.push(p);
                }
            }
        }
        if(stack.empty()){
            return "/";
        }
        String [] paths = stack.toArray(new String[stack.size()]);
        StringBuilder sb = new StringBuilder();
        for(String p : paths){
            sb.append("/");
            sb.append(p);
        }
        return sb.toString();
    }

    void printStack(Stack<String> stack){
        String [] paths = stack.toArray(new String[stack.size()]);
        System.out.println(Arrays.toString(paths));
    }

    public static void main(String args[]){
        Solution s = new Solution();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int N = random.nextInt(100) + 1;
        for(int i = 0; i < N; i++){
            sb.append(getPath(random.nextInt(26), random));
        }
        String path = sb.toString();
        System.out.println(path);
        System.out.println(s.simplifyPath(path));
    }

    static String getPath(int next, Random random){
        char c = (char) (97 + next);
        switch(random.nextInt(7)){
            case 0:
                return "/";
            case 1:
                return "/./";
            case 2:
                return "/../";
            default:
                return Character.toString(c);
        }
    }
}
