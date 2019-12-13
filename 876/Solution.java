import java.util.*;

class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode node = head;
        while(node != null){
            count++;
            node = node.next;
        }
        node = head;
        for(int i = 0; i < count / 2; i++){
            node = node.next;
        }
        return node;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        ListNode head = ListNode.createList(new int[]{1,2,3,4,5});
        System.out.println(s.middleNode(head));
        head = ListNode.createList(new int[]{1,2,3,4,5,6});
        System.out.println(s.middleNode(head));
    }
}

