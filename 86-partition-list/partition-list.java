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
    public ListNode partition(ListNode head, int x) {
        ListNode greater = new ListNode();
        ListNode g = greater;
        ListNode less = new ListNode();
        ListNode l = less;
        ListNode temp = head;

        while (temp != null){
            if (temp.val < x){
                l.next = temp;
                l = l.next;
            }else {
                g.next = temp;
                g = g.next;
            }

            temp = temp.next;
        }
        
        g.next = null;

        l.next = greater.next;

        return less.next;
    }

    // public ListNode merge(ListNode less, ListNode greater){
    //     ListNode temp = less;

    //     while (temp.next != null){
    //         temp = temp.next;
    //     }

    //     while (greater != null){
    //         temp.next = greater;
    //         greater = greater.next;
    //         temp = temp.next;
    //     }

        
    // }
}