import java.util.*;

class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode node = head;
        while(node != null){
            ans <<= 1;
            ans += node.val;
            node = node.next;
        }
        return ans;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.getDecimalValue(ListNode.createList(new int[]{1,0,1})));
        System.out.println(s.getDecimalValue(ListNode.createList(new int[]{0})));
        System.out.println(s.getDecimalValue(ListNode.createList(new int[]{1})));
        System.out.println(s.getDecimalValue(ListNode.createList(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0})));
        System.out.println(s.getDecimalValue(ListNode.createList(new int[]{0,0})));
    }
}
