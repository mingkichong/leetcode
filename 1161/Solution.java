import java.util.*;

class Solution {
    public int maxLevelSumDFS(TreeNode root) {
        ArrayList<Integer> levelSums = new ArrayList<>();
        dfs(root, 1, levelSums);
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

    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> levelSums = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> levelQ = new LinkedList<>();

        queue.add(root);
        levelQ.add(1);
        int levelSum = 0;

        while(queue.size() > 0){
            int level = levelQ.removeFirst();
            TreeNode node = queue.removeFirst();
            levelSum += node.val;

            if(node.left != null){
                queue.add(node.left);
                levelQ.add(level+1);
            }
            if(node.right != null){
                queue.add(node.right);
                levelQ.add(level+1);
            }

            if(levelQ.size() == 0 || level != levelQ.get(0)){
                levelSums.add(levelSum);
                levelSum = 0;
            }
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

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode root = TreeNode.createBinaryTree(new Integer[]{989,null,10250,98693,-89388,null,null,null,-32127});
        System.out.println(s.maxLevelSum(root));
        System.out.println(s.maxLevelSumDFS(root));
    }
}

