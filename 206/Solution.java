import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = head;
        
        while(node != null){ 
            stack.push(node);
            node = node.next;
        }
        
        node = stack.pop();
        head = node;
        
        while(node != null && !stack.empty()){
            node.next = stack.pop();
            node = node.next;
            node.next = null;
        }

        return head;
    }

    public static void main(String args[]){
        ListNode head = null;
        ListNode current = null;
        int [] nums = {1,2,4,3,6};
        for(int i : nums){
            if(head == null){
                current = new ListNode(i);
                head = current;
            }
            else{
                current.next = new ListNode(i);
                current = current.next;
            }
        }
        Solution s = new Solution();
        printList(head);
        printList(s.reverseList(head));
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}