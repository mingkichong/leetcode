import java.util.*;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode node = head;
        ListNode prev = new ListNode(-1);
        ListNode first = prev;
        prev.next = head;
        node = head;
        while(node != null){
            while(node != null && node.val == val){
                prev.next = node.next;
                node = node.next;
            }
            prev = node;
            if(node != null){
                node = node.next;
            }
        }
        return first.next;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        ListNode head = ListNode.createList(new int[]{1,1,1,1,1,1,11,1,1,1,1,1});
        System.out.println(s.removeElements(head, 1));
    }
}

