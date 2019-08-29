import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public TreeNode recoverFromPreorder(String S) {
        List<Integer> nums = new ArrayList<>();
        List<Integer> dashes = new ArrayList<>();
        char [] A = S.toCharArray();
        int start = 0; int startDash = 0;
        char prevC = '-';
        int maxDashLevel = 0;
        for(int i = 0; i < S.length(); i++){
            if(isNum(A[i])){
                if(isDash(prevC)){
                    int length = S.substring(startDash, i).length();
                    maxDashLevel = Math.max(maxDashLevel, length);
                    dashes.add(length);
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

        List<List<TreeNode>> BFSTree = new ArrayList<>();
        for(int i = 0; i <= maxDashLevel; i++){
            List<TreeNode> list = new ArrayList<>();
            BFSTree.add(list);
        }
        for(int i = 0; i < dashes.size(); i++){
            TreeNode node = new TreeNode(nums.get(i));
            BFSTree.get(dashes.get(i)).add(node);
        }

        for(int i = 0; i < BFSTree.size() - 1; i++){
            List<TreeNode> parents = BFSTree.get(i);
            List<TreeNode> children = BFSTree.get(i+1);
            int childrenIndex = 0;
            for(int j = 0; j < parents.size(); j++){
                TreeNode parent = parents.get(j);
                for(int k = 0; k < 2; k++){
                    if(childrenIndex < children.size()){
                        if(parent.left == null || parent.right == null){
                            TreeNode child = children.get(childrenIndex);
                            childrenIndex++;
                            if(parent.left == null){
                                parent.left = child;
                            }
                            else{
                                parent.right = child;
                            }
                        }
                    }
                }
            }
        }
        return BFSTree.get(0).get(0);
    }

    private boolean isDash(char c){
        return c == '-';
    }

    private boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String S = "1-2--3---4-5--6---7";
        //expect 1,2,3,4,5,6,7
        TreeNode.printWithOrder(s.recoverFromPreorder(S), TraverseOrder.PREORDER);
    }
}

