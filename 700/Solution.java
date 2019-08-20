import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        return searchBST((val < root.val) ? root.left : root.right, val);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode node = s.searchBST(TreeNode.createBinarySearchTree(new int[]{5,4,6,8,12,3,14,9,4,15,6,7,10,11,2,3,}), 13);
        TreeNode.printWithOrder(node, TraverseOrder.INORDER);
    }
}
