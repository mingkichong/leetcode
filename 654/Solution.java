import java.util.*;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        int maxIndex = getMaxIndex(nums, l, r);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = constructMaximumBinaryTree(nums, l, maxIndex-1);
        node.right = constructMaximumBinaryTree(nums, maxIndex + 1, r);
        return node;
    }

    private int getMaxIndex(int[] nums, int l, int r){
        int maxIndex = l;
        for(int i = l+1; i <= r; i++){
            if(nums[maxIndex] < nums[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        TreeNode.printTreeWithStructure(
            s.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5})
        );
    }
}

