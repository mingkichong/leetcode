/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;
    public int maxDepth(TreeNode root) {
        traverse(root, 1);
        return max;
    }
    
    public void traverse(TreeNode n, int level){
        if(n == null){return;}
        traverse(n.left,  level + 1);
        traverse(n.right, level + 1);
        max = Math.max(max, level);
    }
}