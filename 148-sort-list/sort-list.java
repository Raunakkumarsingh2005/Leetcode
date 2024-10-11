/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
public ListNode getMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;  // Keep track of the node before slow

    while (fast != null && fast.next != null) {
        prev = slow;        // Store the node before slow
        slow = slow.next;   // Move slow one step
        fast = fast.next.next;  // Move fast two steps
    }

    if (prev != null) {
        prev.next = null;   // Cut the list into two halves
    }

    return slow;   // Return the start of the second half (midpoint)
}

public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    // Find the mid-point and split the list
    ListNode mid = getMid(head);
    
    // Recursively sort both halves
    ListNode left = sortList(head);
    ListNode right = sortList(mid);

    // Merge the sorted halves
    return merge(left, right);
}

public ListNode merge(ListNode h1, ListNode h2) {
    ListNode dummy = new ListNode(0);  // Dummy node to simplify the merge logic
    ListNode current = dummy;

    while (h1 != null && h2 != null) {
        if (h1.val <= h2.val) {
            current.next = h1;
            h1 = h1.next;
        } else {
            current.next = h2;
            h2 = h2.next;
        }
        current = current.next;
    }

    // Append any remaining nodes
    if (h1 != null) {
        current.next = h1;
    } else {
        current.next = h2;
    }

    return dummy.next;  // Return the merged list without the dummy node
}


}