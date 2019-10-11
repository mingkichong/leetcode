import java.util.*;

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        else if(root1 == null || root2 == null || (root1.val != root2.val)){
            return false;
        }
        return flipEquiv(root1.left, root2.left)  && flipEquiv(root1.right, root2.right) ||
               flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode root1 = TreeNode.createBinaryTree(new Integer[]{0, null, 1});
        TreeNode root2 = TreeNode.createBinaryTree(new Integer[]{0, null, 1});
        System.out.println(s.flipEquiv(root1, root2));

        root1 = TreeNode.createBinaryTree(new Integer[]{1,2,3,4,5,6,null,null,null,7,8});
        root2 = TreeNode.createBinaryTree(new Integer[]{1,3,2,null,6,4,5,null,null,null,null,8,7});
        System.out.println(s.flipEquiv(root1, root2));

    }
}

