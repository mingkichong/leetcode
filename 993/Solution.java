import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode [] parents = new TreeNode[2];
        return traverse(root, x, 1, null, parents, 0) == traverse(root, y, 1, null, parents, 1) &&
               parents[0] != parents[1];
    }

    private int traverse(TreeNode node, final int VAL, int depth, TreeNode parent, TreeNode [] parents, int index){
        if(node == null){
            return 0;
        }
        if(node.val == VAL){
            parents[index] = parent;
            return depth;
        }
        return traverse(node.left,  VAL, depth + 1, node, parents, index) +
               traverse(node.right, VAL, depth + 1, node, parents, index);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [][] nums = {{1},{2},{3},null,{4},null,{5}};
        System.out.println(s.isCousins(TreeNode.createBinaryTree(nums), 5, 4));
    }
}

