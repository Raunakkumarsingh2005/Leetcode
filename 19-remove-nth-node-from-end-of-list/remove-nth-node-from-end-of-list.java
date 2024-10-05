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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode present = head;
        ListNode post = head.next;

        while (present != null){
            present.next = prev;
            prev = present;
            present = post;
            if (post != null){
                post = post.next;
            }
        }

        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){
            return head.next;
        }

        ListNode rhead = reverse(head);
        ListNode temp = rhead;

        if (n == 1){
            rhead = rhead.next;
            head = reverse(rhead);
            return head;
        }
        if (n > 2){
            for (int i = 1; i < n-1; i++){
                temp = temp.next;
            }
        }

        // deleting node
        temp.next = temp.next.next;

        // re-reversing the list
        head = reverse(rhead);
        return head;
    }
}