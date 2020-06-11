import java.util.*;

class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return insert(num, 0, num.length-1);
    }

    TreeNode insert(int [] num, int l, int r){
        if(l > r){
            return null;
        }
        int mid = (r + l) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = insert(num, l, mid-1);
        node.right = insert(num, mid+1, r);
        return node;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
