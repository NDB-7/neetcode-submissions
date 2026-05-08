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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode node = head;

        int length = 1;
        while (node.next != null) {
            node = node.next;
            length++;
        }

        int curr = 0;
        node = dummy;

        while (length - n != curr) {
            node = node.next;
            curr++;
        }

        node.next = node.next.next;

        return dummy.next;
    }
}
