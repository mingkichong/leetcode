import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public boolean isValidBST(TreeNode node) {
        return isValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isValidBST(TreeNode node, int min, int max) {
        if(node == null){
            return true;
        }
        if(node.val >= max || node.val <= min){
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }


    // boolean isValidBST(TreeNode node){
    //     List<TreeNode> list = new ArrayList<TreeNode>();
    //     inorder(node, list);
    //     TreeNode prevNode = null;
    //     for(TreeNode n : list){
    //         if(prevNode != null){
    //             if(prevNode.val >= n.val){
    //                 return false;
    //             }
    //         }
    //         prevNode = n;
    //     }
    //     return true;
    // }

    // void inorder(TreeNode node, List<TreeNode> list){
    //     if(node == null){
    //         return;
    //     }
    //     inorder(node.left, list);
    //     list.add(node);
    //     inorder(node.right, list);
    // }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode node = TreeNode.createBinaryTree(new Integer[]{1,0,2});
        System.out.println(s.isValidBST(node));
    }
}

