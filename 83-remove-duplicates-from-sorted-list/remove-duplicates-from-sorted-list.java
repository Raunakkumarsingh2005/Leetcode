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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

    
        ListNode curr, prev;
        curr = head.next;
        prev = head;
        int value = head.val;   

        while (curr != null) {
            if (curr.val == value) {
                prev.next = curr.next;
                curr = curr.next;
                continue;
            }

            value = curr.val;
            prev = prev.next;
            curr = curr.next;
        }

        return head;
    }
}