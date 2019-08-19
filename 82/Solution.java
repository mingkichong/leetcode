import java.util.*;

class Solution {
    public ListNode deleteDuplicates(ListNode N) {
        if(N == null){
            return null;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = N;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        while(curr != null && next != null){
            if(curr.val != next.val){
                prev = prev.next;
                curr = curr.next;
                next = next.next;
            }
            else{
                while(next != null && curr.val == next.val){
                    next = next.next;
                }
                prev.next = next;
                curr = next;
                if(next != null){
                    next = next.next;
                }
            }
        }
        return head.next;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Random random = new Random();
        // int [] A = {1,2,3,4,5,6};
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

