import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public String __something() {
        return "SAMPLE";
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }
        TreeNode n = new TreeNode( (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        n.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        n.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return n;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode t1 = TreeNode.createBinaryTree(new Integer[]{1,3,2,5});
        TreeNode t2 = TreeNode.createBinaryTree(new Integer[]{2,1,3,null,4,null,7});

        if(RANDOM_INPUT){
            Random random = new Random();
            Integer [] nums = new Integer[random.nextInt(101) + 20];
            for(int i = 0; i < nums.length; i++){
                nums[i] = random.nextInt(101);
            }
            t1 = TreeNode.createBinaryTree(nums);
            nums = new Integer[random.nextInt(101) + 20];
            for(int i = 0; i < nums.length; i++){
                nums[i] = random.nextInt(101);
            }
            t1 = TreeNode.createBinaryTree(nums);
        }

        TreeNode.printTreeWithStructure(s.mergeTrees(t1, t2));
    }
}

