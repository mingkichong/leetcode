import java.util.*;

class Solution {
    final static boolean DEBUG = true;
    final static boolean RANDOM_INPUT = true;

    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        return traverse(root, root.val);
    }

    boolean traverse(TreeNode node, int val){
        if(node == null){
            return true;
        }
        if(node.val != val){
            return false;
        }
        return traverse(node.left, val) && traverse(node.right, val);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {2,2,2,2,2};
        if(Solution.RANDOM_INPUT){
            Random random = new Random(10000);
            int len = random.nextInt(1000) + 10;
            nums = new int[len];
            int val = random.nextInt(100);
            for(int i = 0; i < len; i++){
                nums[i] = random.nextInt((int) 1.0e3) < 1.0e1 ? random.nextInt(100) : val;
                if(Solution.DEBUG){
                    if(nums[i] != val){
                        System.out.println(nums[i]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(s.isUnivalTree(TreeNode.createBinaryTree(nums)));
    }
}

