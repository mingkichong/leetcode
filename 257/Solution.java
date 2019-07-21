import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        traverse(root, list, "");
        return list;
    }

    public void traverse(TreeNode node, List<String> list, String path){
        if(node == null){
            return;
        }
        path += node.val;
        if(node.left == null && node.right == null){
            list.add(path);
            return;
        }
        path +="->";
        traverse(node.left, list, path);
        traverse(node.right, list, path);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
