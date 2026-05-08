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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse 2nd half

        ListNode prev = slow, curr = slow.next, next;
        prev.next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Merge
        ListNode l1 = head, l2 = prev;
        ListNode l1n, l2n;

        while (l2.next != null) {
            l1n = l1.next;
            l2n = l2.next;

            l1.next = l2;
            l2.next = l1n;
            l1 = l1n;
            l2 = l2n;
        }
    }
}
