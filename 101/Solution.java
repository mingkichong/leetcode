import java.util.*;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null || p.val != q.val){
           return false;
        }
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
        int [][] nums  = {{1},{2},{2},{3},{4},{4},{3}};
        TreeNode node1 = TreeNode.createBinaryTree(nums);
        System.out.println(s.isSymmetric(node1));
    }
}

