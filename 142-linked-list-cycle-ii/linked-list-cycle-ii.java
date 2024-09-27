/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        int count = countCycle(head);
        if (count == 0){
            return null;
        }
        while (count != 0){
            s = s.next;
            count--;
        }

        while (f != s){
            f = f.next;
            s = s.next;
        }

        return f;
    }

    public int countCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp;
        int count = 0;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow){
                temp = slow;
                do {
                    temp = temp.next;
                    count++;
                }while (temp != fast);

                return count;

            }
        }

        return count;
    }
}