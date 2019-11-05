import java.util.*;

class Solution {
    TreeNode resultRoot = null;
    TreeNode current = null;

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return resultRoot;
    }

    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        if(resultRoot == null){
            resultRoot = new TreeNode(node.val);;
            current = resultRoot;
        }
        else{
            current.right = new TreeNode(node.val);
            current = current.right;
        }
        inOrder(node.right);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode root = TreeNode.createBinaryTree(new Integer[]{5,3,6,2,4,null,8,1,null,null,null,7,9});
        System.out.println(s.increasingBST(root));
    }
}

