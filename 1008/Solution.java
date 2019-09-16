import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            insert(root, preorder[i]);
        }
        return root;
    }

    private void insert(TreeNode node, int val){
        if(val < node.val){
            if(node.left == null){
                node.left = new TreeNode(val);
            }
            else{
                insert(node.left, val);
            }
        }
        else{
            if(node.right == null){
                node.right = new TreeNode(val);
            }
            else{
                insert(node.right, val);
            }
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode root = s.bstFromPreorder(new int[]{8,5,1,7,10,12});
        TreeNode.printTreeWithStructure(root);
    }
}

