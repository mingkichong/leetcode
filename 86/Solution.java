import java.util.*;

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode left = null, l = null, right = null, r = null;
        ListNode node = head;
        while(node != null){
            ListNode next = node.next;
            if(node.val < x){
                if(left == null){
                    left = node;
                    l = left;
                }
                else{
                    l.next = node;
                    l = l.next;
                }
            }
            else{
                if(right == null){
                    right = node;
                    r = right;
                }
                else{
                    r.next = node;
                    r = r.next;
                }
            }
            node = next;
        }
        if(r != null){
            r.next = null;
        }
        if(left != null){
            l.next = right;
            return left;
        }
        return right;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        ListNode node = ListNode.createRandomList(20, 1, 15, false);
        // ListNode node = ListNode.createList(new int[]{});
        System.out.println(node);
        int x = 10;
        System.out.println(s.partition(node, x));
    }
}

