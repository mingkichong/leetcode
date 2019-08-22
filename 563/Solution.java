import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int findTilt(TreeNode node) {
        int [] sum = new int[1];
        traverse(node, sum);
        return sum[0];
    }

    private int traverse(TreeNode node, int[] sum){
        if(node == null){
            return 0;
        }
        int left = traverse(node.left, sum);
        int right = traverse(node.right, sum);
        sum[0] += Math.abs(left-right);
        return left + right + node.val ;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5,6,7,8,9,0};
        TreeNode root = TreeNode.createBinaryTree(nums);
        System.out.println(s.findTilt(root));
    }
}
