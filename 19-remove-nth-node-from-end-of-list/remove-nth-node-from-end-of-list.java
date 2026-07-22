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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int length = length(head);

        int prev = length - n;

        if (prev == 0) {
            head = head.next;
            return head;
        }

        for (int i = 1; i < prev; i++) {
            node = node.next;
        }

        node.next = node.next.next;
    
        return head;
    }

    public int length(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }
}