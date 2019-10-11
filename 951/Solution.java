import java.util.*;

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        else if(root1 == null || root2 == null || (root1.val != root2.val)){
            return false;
        }
        if(root1.left != null && root2.left != null && root1.left.val == root2.left.val ||
           root1.right != null && root2.right != null && root1.right.val == root2.right.val){
            return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        }
        else{
            return flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode root1 = TreeNode.createBinaryTree(new Integer[]{0, null, 1});
        TreeNode root2 = TreeNode.createBinaryTree(new Integer[]{0, null, 1});
        System.out.println(s.flipEquiv(root1, root2));
    }
}

