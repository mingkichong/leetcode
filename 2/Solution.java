import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    /*
    // fail due to primitive type overflow
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<Integer>();
        while(l1 != null){
            stack.push(l1.val);
            l1 = l1.next;
        }
        long num1 = 0;
        while(!stack.empty()){
            num1 *= 10;
            num1 += stack.pop();
        }

        while(l2 != null){
            stack.push(l2.val);
            l2 = l2.next;
        }
        long num2 = 0;
        while(!stack.empty()){
            num2 *= 10;
            num2 += stack.pop();
        }

        long ans = num1 + num2;
        if(ans == 0){
            return new ListNode(0);
        }
        ListNode head = null, node = null;
        while(ans > 0){
            long digit = ans%10;
            if(head == null){
                head = new ListNode((int) digit);
                node = head;
            }
            else{
                node.next = new ListNode((int) digit);
                node = node.next;
            }
            ans /= 10;
        }
        return head;
    }
    */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        int remainder = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carryOver;
            carryOver = sum / 10;
            remainder = sum % 10;
            ans.add(remainder);
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = (l1 != null) ? l1 : l2;
        while(remain != null){
            int sum = remain.val + carryOver;
            carryOver = sum / 10;
            remainder = sum % 10;
            ans.add(remainder);
            remain = remain.next;
        }
        if(carryOver > 0){
            ans.add(carryOver);
        }
        int[] nums = new int[ans.size()];
        for(int i = 0; i < nums.length; i++){
            nums[i] = ans.get(i);
        }
        return Solution.addToList(nums);
    }

    static ListNode addToList(long num){
        if(num == 0){
            return addToList(new int[]{0});
        }
        long N = num; int count = 0;
        while(N > 0){
            count++;
            N /= 10;
        }
        int [] nums = new int[count];
        int i = 0;
        while(num > 0){
            nums[i] = (int) num % 10;
            i++;
            num /= 10;
        }
        return addToList(nums);
    }

    static ListNode addToList(int [] nums){
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

    static void printList(ListNode node){
        if(node == null){
            System.out.println("null");
            return;
        }
        while(node != null){
            System.out.print(node.val);
            node = node.next;
            if(node != null){
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]){
        Solution s = new Solution();
        ListNode l1 = Solution.addToList(new int[]{1,9,9,9,9,9,9,9,9,9,9,9,9,9});
        ListNode l2 = Solution.addToList(9);
        ListNode node = s.addTwoNumbers(l1, l2);
        Solution.printList(l1);
        Solution.printList(l2);
        Solution.printList(node);
    }
}
