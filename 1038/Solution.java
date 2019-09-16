import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        sum = treeSum(root);
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node){
        if(node == null){
            return;
        }
        traverse(node.left);
        int val = node.val;
        node.val = sum;
        sum -= val;
        traverse(node.right);
    }

    private int treeSum(TreeNode node){
        if(node == null){
            return 0;
        }
        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode root = TreeNode.createBinaryTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        root = s.bstToGst(root);
        TreeNode.printTreeWithStructure(root);
    }
}

