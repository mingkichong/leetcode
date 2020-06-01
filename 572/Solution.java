import java.util.*;

class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (isIdentical(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    private boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        TreeNode sNode = null, tNode = null;

        sNode = TreeNode.createBinaryTree(new Integer[] {3, 4, 5, 1, 2});
        tNode = TreeNode.createBinaryTree(new Integer[] {4, 1, 2});
        System.out.println(s.isSubtree(sNode, tNode)); // true

        sNode = TreeNode.createBinaryTree(new Integer[] {3, 4, 5, 1, 2, null, null, null, null, 0});
        tNode = TreeNode.createBinaryTree(new Integer[] {4, 1, 2});
        System.out.println(s.isSubtree(sNode, tNode)); // false

        sNode = TreeNode.createBinaryTree(new Integer[] {1, 1});
        tNode = TreeNode.createBinaryTree(new Integer[] {1});
        System.out.println(s.isSubtree(sNode, tNode)); // true

        sNode = TreeNode.createBinaryTree(new Integer[] {3, 4, 5, 1, null, 2});
        tNode = TreeNode.createBinaryTree(new Integer[] {3, 1, 2});
        System.out.println(s.isSubtree(sNode, tNode)); // false
    }
}

