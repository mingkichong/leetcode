import java.util.*;

class Solution {
    public boolean isBFS = true;

    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> levelSums = new ArrayList<>();
        if(isBFS){
            bfs(root, levelSums);
        }
        else{
            dfs(root, 1, levelSums);
        }
        int max = Integer.MIN_VALUE;
        int maxLevel = 0;
        for(int i = 0; i < levelSums.size(); i++){
            if(max < levelSums.get(i)){
                max = levelSums.get(i);
                maxLevel = i;
            }
        }
        return maxLevel + 1;
    }

    private void dfs(TreeNode node, int depth, ArrayList<Integer> levelSums){
        if(levelSums.size() < depth){
            levelSums.add(node.val);
        }
        else{
            levelSums.set(depth-1, levelSums.get(depth-1) + node.val);
        }
        if(node.left != null){
            dfs(node.left, depth + 1, levelSums);
        }
        if(node.right != null){
            dfs(node.right, depth + 1, levelSums);
        }
    }

    private void bfs(TreeNode node, ArrayList<Integer> levelSums){
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> levelQ = new LinkedList<>();

        queue.add(node);
        levelQ.add(1);
        int levelSum = 0;

        while(queue.size() > 0){
            int level = levelQ.removeFirst();
            TreeNode n = queue.removeFirst();
            levelSum += n.val;

            if(n.left != null){
                queue.add(n.left);
                levelQ.add(level+1);
            }
            if(n.right != null){
                queue.add(n.right);
                levelQ.add(level+1);
            }

            if(levelQ.size() == 0 || level != levelQ.get(0)){
                levelSums.add(levelSum);
                levelSum = 0;
            }
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode root = TreeNode.createBinaryTree(new Integer[]{1,7,0,7,-8,null,null});
        // TreeNode root = TreeNode.createBinaryTree(new Integer[]{989,null,10250,98693,-89388,null,null,null,-32127});
        s.isBFS = true;
        System.out.println(s.maxLevelSum(root));
        s.isBFS = false;
        System.out.println(s.maxLevelSum(root));
    }
}

