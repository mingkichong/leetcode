import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    static ListNode createList(Integer nums[]){
        return createList(Arrays.stream(nums)
                                .mapToInt(i -> (i == null) ? 0 : i) //make null to 0
                                .toArray());
    }

    static ListNode createList(int nums[]){
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
        return head;
    }

    static ListNode createRandomList(int length, int minVal, int maxVal, boolean isSorted){
        Random random = new Random();
        int [] A = new int[length];
        for(int i = 0; i < A.length; i++){
            A[i] = random.nextInt(maxVal-minVal) + minVal;
        }
        if(isSorted){
            Arrays.sort(A);
        }
        return createList(A);
    }

    @Override public String toString(){
        ListNode node = this;
        StringBuilder sb = new StringBuilder();
        while(node != null){
            sb.append(node.val);
            if(node.next != null){
                sb.append(" -> ");
            }
            node = node.next;
        }
        return sb.toString();
    }
}
