import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public TreeNode insertIntoBST(TreeNode node, int val) {
        TreeNode newNode = new TreeNode(val);
        if(node == null){
            return newNode;
        }
        insert(node, null, newNode);
        return node;
    }

    public void insert(TreeNode node, TreeNode parent, TreeNode newNode){
        if(node == null){
            if(newNode.val < parent.val){
                parent.left = newNode;
            }
            else{
                parent.right = newNode;
            }
        }
        else{
            if(newNode.val < node.val){
                insert(node.left, node, newNode);
            }
            else{
                insert(node.right, node, newNode);
            }
        }
    }


    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode root = TreeNode.createBinarySearchTree(new int[]{4,2,7,1,3});
        root = s.insertIntoBST(root, 5);
        TreeNode.printTreeWithStructure(root);
    }
}

