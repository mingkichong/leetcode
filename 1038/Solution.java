import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null){ return null; }
        bstToGst(root.right);
        root.val = sum + root.val;
        sum = root.val;
        bstToGst(root.left);
        return root;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode root = TreeNode.createBinaryTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        root = s.bstToGst(root);
        TreeNode.printTreeWithStructure(root);
    }
}

