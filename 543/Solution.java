import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public int diameterOfBinaryTree(TreeNode root) {
        List<TreeNode> leaves = new ArrayList<TreeNode>();
        findLeaves(root, leaves);
        if(Solution.DEBUG){
            for(TreeNode node : leaves){
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
        return -1;
    }

    void findLeaves(TreeNode node, List<TreeNode> leaves){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            leaves.add(node);
        }
        findLeaves(node.left, leaves);
        findLeaves(node.right, leaves);
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

