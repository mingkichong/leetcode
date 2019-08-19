import java.util.*;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode curr = head;
        ListNode next = curr.next;
        while(curr != null){
            while(next != null && curr.val == next.val){
                next = next.next;
            }
            curr.next = next;
            curr = curr.next;
            if(curr != null && curr.next != null){
                next = curr.next;
            }
        }
        return head;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
        // int [] A = {1,1,1,1,1,1,1};
        int [] A = new int[random.nextInt(40) + 10];
        for(int i = 0; i < A.length; i++){
            A[i] = random.nextInt(20) + 1;
        }
        Arrays.sort(A);
        ListNode node = ListNode.createList(A);
        System.out.println((node == null) ? "--NULL--" : node);
        node = s.deleteDuplicates(node);
        System.out.println((node == null) ? "--NULL--" : node);
    }
}
