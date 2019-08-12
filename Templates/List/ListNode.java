public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

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

     @Override public String toString(){
        ListNode node = this;
        StringBuilder sb = new StringBuilder();
        while(node != null){
            sb.append(node.val + ", ");
            node = node.next;
        }
        sb.append("\n");
        return sb.toString();
     }
}
