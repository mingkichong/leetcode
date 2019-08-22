import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int diameterOfBinaryTree(TreeNode root) {
        int [] max = {0};
        findLeaves(root, max);
        return max[0];
    }

    private int findLeaves(TreeNode node, int[] max){
        if(node == null){
            return 0;
        }
        int left  = findLeaves(node.left, max);
        int right = findLeaves(node.right, max);
        max[0] = Math.max(max[0], left+right);
        return 1 + Math.max(left, right);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Integer [] nums = new Integer[]{5,2,9,1,4,7,10,null,null,3,null,6,8};
        // int [][] nums = {{5},{2},{9},{1},{4},{7},{10},null,null,{3},null,{6},{8}};
        TreeNode root = TreeNode.createBinaryTree(nums);
        TreeNode.printBFS(root);
        System.out.println(s.diameterOfBinaryTree(root));
    }
}

