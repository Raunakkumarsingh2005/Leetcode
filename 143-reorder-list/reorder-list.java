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
    public ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

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

    public void reorderList(ListNode head) {
        ListNode temp;
        ListNode a = head;
        ListNode mid = getMid(head);
        ListNode f = head;
        ListNode hs = reverse(mid);
        ListNode l = hs;

        while (l.next != null){
            temp = f.next;
            f.next = l;
            f = temp;

            temp = l.next;
            l.next = f;
            l = temp;
        }
    }
}