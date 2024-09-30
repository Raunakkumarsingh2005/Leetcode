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
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
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
}