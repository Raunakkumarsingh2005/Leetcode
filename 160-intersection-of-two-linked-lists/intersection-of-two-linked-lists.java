/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listA = headA;
        ListNode listB = headB;

        int a = length(headA);
        int b = length(headB);
        int c = Math.abs(a-b);

        for (int i = 0; i < c; i++) {
            if (a > b) listA = listA.next;
            if (a < b) listB = listB.next;
        }

        while (listA != null || listB != null) {
            if (listA == listB) {
                return listA;
            }

            listA = listA.next;
            listB = listB.next;

            
        }

        return null;
    }

    public int length(ListNode headA) {
        int count = 0;

        while (headA != null) {
            headA = headA.next;
            count++;
        }

        return count;


    }
}