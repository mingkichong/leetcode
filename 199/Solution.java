import java.util.*;

class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        travese(root, 1, result);
        return result;
    }

    private void travese(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (level > result.size()) {
            result.add(node.val);
        }
        travese(node.right, level + 1, result);
        travese(node.left, level + 1, result);
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.rightSideView(TreeNode.createBinaryTree(new Integer[] {1, 2, 3, null, 5, null, 4})));
        System.out.println(s.rightSideView(TreeNode.createBinaryTree(new Integer[] {1, 2, 3, null, 5, null, 4, 6})));
        System.out.println(s.rightSideView(TreeNode.createBinaryTree(new Integer[] {1})));
    }
}
