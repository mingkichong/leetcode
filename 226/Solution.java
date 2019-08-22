import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public TreeNode invertTree(TreeNode node) {
        if(node == null){
            return node;
        }
        invertTree(node.left);
        invertTree(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.createBinaryTree(nums);
        root = s.invertTree(root);
        TreeNode.printWithOrder(root, TraverseOrder.INORDER);
    }
}

