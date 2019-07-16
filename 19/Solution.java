import java.util.*;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        ListNode node = head;
        ListNode prev = head;
        int length = 1;
        while(node.next != null){
            length++;
            prev = node;
            node = node.next;
        }
        if(n == 1 && length == 1){
            return null;
        }

        if(n == 1){
            prev.next = null;
            return head;
        }
        if(n == length){
            return head.next;
        }

        node = head;
        prev = head;
        length = length - n;
        while(length > 0){
            length--;
            prev = node;
            node = node.next;
        }
        prev.next = node.next;
        return head;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        int [] nums = {2,4,5,6,8,10};
        System.out.println(Arrays.toString(nums));
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
        int [] order = {2, 4, 4, 3, 1, 1};
        for(int o : order){
            System.out.print("[");
            head = s.removeNthFromEnd(head, o);
            node = head;
            while(node != null){
                System.out.print(node.val);
                System.out.print(", ");
                node = node.next;
            }
            System.out.println("] " + o);
        }
    }
}
