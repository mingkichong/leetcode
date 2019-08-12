import java.util.*;

class Solution {
    public int rangeSumBST(TreeNode node, int L, int R) {
        if(node == null){
            return 0;
        }
        return  rangeSumBST(node.left, L, R)
              + rangeSumBST(node.right, L, R)
              + ((node.val >= L && node.val <= R) ? node.val : 0);
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [][] nums = {{10},{5},{15},{3},{7},{13},{18},{1},null,{6}};
        int L = 6, R = 10;
        TreeNode head = TreeNode.createList(nums);
        System.out.println(s.rangeSumBST(head, L, R));
    }
}
