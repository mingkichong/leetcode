/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = null; ListNode ansHead = null;

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            ans = l1;
            ansHead = l1;
            l1 = l1.next;
        }
        else{
            ans = l2;
            ansHead = l2;
            l2 = l2.next;
        }
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ans.next = l1;
                l1 = l1.next;
            }
            else{
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        if(l1 != null){
            ans.next = l1; 
        }else if(l2 != null){
            ans.next = l2;
        }
        return ansHead;
    }
}