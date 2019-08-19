import java.util.*;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null || p.val != q.val){
           return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
        int [][] nums  = {{8},{12},{18},{1},{4},null,{9},{10},{5},{6},{3}};
        int [][] nums2 = {{8},{12},{18},{1},{4},null,{7},{10},{5},{6},{3}};
        TreeNode node1 = TreeNode.createBinaryTree(nums);
        TreeNode node2 = TreeNode.createBinaryTree(nums2);
        System.out.println(s.isSameTree(node1, node2));
    }
}

