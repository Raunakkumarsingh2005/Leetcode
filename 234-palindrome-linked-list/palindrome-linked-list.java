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
    public ListNode middleNode(ListNode head){
        ListNode f = head;
        ListNode s = head;

        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    public ListNode reverseList(ListNode head){
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

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode hs = reverseList(mid);

        while (head != null && hs != null){
            if (head.val != hs.val){
                return false;
            }

            head = head.next;
            hs = hs.next;
        }

        return true;
    }
}