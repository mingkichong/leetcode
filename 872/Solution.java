import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String __something() {
        return "SAMPLE";
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        leafNodes(root1, list1);
        leafNodes(root2, list2);
        if(list1.size() != list2.size()){
            return false;
        }
        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i) != list2.get(i)){
                return false;
            }
        }
        return true;
    }

    void leafNodes(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        leafNodes(node.left, list);
        if(node.left == null && node.right == null){
            list.add(node.val);
        }
        leafNodes(node.right, list);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [][] nums1 = {{1},{2},{3},null,{4},{5},{6},{7},null,{8},{9},null,{10}};
        TreeNode root1 = TreeNode.createBinaryTree(nums1);
        int [][] nums2 = {{1},{2},{3},{7},{4},{5},{6},null,null,null,{8},null,{9},{10},null};
        TreeNode root2 = TreeNode.createBinaryTree(nums2);
        System.out.println(s.leafSimilar(root1, root2));
    }
}

