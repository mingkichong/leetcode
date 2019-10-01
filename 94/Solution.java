import java.util.*;

class Solution {

    public List<Integer> inorderTraversal(TreeNode node) {
        if(node == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(inorderTraversal(node.left));
        list.add(node.val);
        list.addAll(inorderTraversal(node.right));
        return list;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode node = TreeNode.createBinaryTree(new Integer[]{1,null,2,3});
        System.out.println(s.inorderTraversal(node));
    }
}
