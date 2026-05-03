// Reverse Nodes in k-Group
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count < k) return head;

        ListNode prev = reverseKGroup(curr, k);

        while (count-- > 0) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}