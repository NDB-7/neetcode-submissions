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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode counter = head;
        ListNode dummy = new ListNode();
        dummy.next = head;

        while (counter.next != null) {
            len++;
            counter = counter.next;
        }

        ListNode prev = dummy;
        ListNode node = head;

        while (node.next != null && len > n) {
            prev = node;
            node = node.next;
            len--;
        }

        prev.next = node.next;

        return dummy.next;
    }
}
