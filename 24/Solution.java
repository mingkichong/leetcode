import java.util.*;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        head = node;

        while(node.next != null && node.next.next != null){
            ListNode next = node.next;
            ListNode next2 = next.next;
            ListNode next3 = next2.next;
            ListNode temp = node.next;
            node.next = next2;
            next2.next = temp;
            temp.next = next3;
            node = node.next.next;
        }
        return head.next;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = new int[]{1,2,3,4,5};

        ListNode head = null;
        ListNode node = null;
        for(int n : nums){
            if(head == null){
                head = new ListNode(n);
                node = head;
            }
            else{
                node.next = new ListNode(n);
                node = node.next;
            }
        }

        head = s.swapPairs(head);
        node = head;
        while(node != null){
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println();
    }
}
