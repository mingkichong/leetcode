import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public TreeNode insertIntoBST(TreeNode node, int val) {
        if(node == null){
            return new TreeNode(val);
        }
        else{
            if(val < node.val){
                node.left = insertIntoBST(node.left, val);
            }
            else{
                node.right = insertIntoBST(node.right, val);
            }
        }
        return node;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode root = TreeNode.createBinarySearchTree(new int[]{4,2,7,1,3});
        root = s.insertIntoBST(root, 5);
        TreeNode.printTreeWithStructure(root);
    }
}

