/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode node = l3;
        int carry = 0;

        if (l1 == null && l2 == null){
            return l3;
        }

        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if (sum > 9){
                node.val = sum%10;
                carry = sum/10;
            }else{
                node.val = sum;
            }
            
            l1 = l1.next;
            l2 = l2.next;
            
            // creating and moving to next node
            if ((l1 != null || l2 != null )|| carry == 1){
                ListNode temp = new ListNode();
                node.next = temp;
                node = node.next;
                node.val = carry;
            }
        }

        while (l1 != null){
            int sum = l1.val + carry;
            carry = 0;
            if (sum > 9){
                node.val = sum%10;
                carry = sum/10;
            }else{
                node.val = sum;
            }
            l1 = l1.next;

            // creating and moving to next node
            if (l1 != null || carry == 1){
                ListNode temp = new ListNode();
                node.next = temp;
                node = node.next;
                node.val = carry;
            }
        }

        while (l2 != null){
            int sum = l2.val + carry;
            carry = 0;
            if (sum > 9){
                node.val = sum%10;
                carry = sum/10;
            }else{
                node.val = sum;
            }
            l2 = l2.next;

            // creating and moving to next node
            if (l2 != null || carry == 1){
                ListNode temp = new ListNode();
                node.next = temp;
                node = node.next;
                node.val = carry;
            }
        }

        return l3;
    }
}