import java.util.*;

class Solution {

    public List<TreeNode> allPossibleFBT(int N) {
        if(N < 1 || N%2 == 0){
            return new ArrayList<>();
        }
        if(N == 1){
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(0));
            return list;
        }
        List<TreeNode> list = allPossibleFBT(N-2);
        List<TreeNode> returnList = new ArrayList<>();
        for(TreeNode node : list){

        }
        return list;
    }

    private void addChildren(TreeNode node){
        node.left  = new TreeNode(0);
        node.right = new TreeNode(0);
    }

    private TreeNode duplicateTree(TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode newNode = new TreeNode(node.val);
        newNode.left  = duplicateTree(node.left);
        newNode.right = duplicateTree(node.right);
        return newNode;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        final int N = 3;
        List<TreeNode> nodes = s.allPossibleFBT(N);
        for(TreeNode n : nodes){
            TreeNode.printTreeWithStructure(n);
        }
    }
}

