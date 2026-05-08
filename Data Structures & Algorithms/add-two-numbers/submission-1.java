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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int rem = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + rem;
            rem = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null || l2 != null) {
            ListNode l = (l1 != null) ? l1 : l2;
            while (l != null) {
                int sum = l.val + rem;
                rem = sum / 10;
                node.next = new ListNode(sum % 10);
                node = node.next;
                l = l.next;
            }
        }

        if (rem > 0) node.next = new ListNode(rem);

        return dummy.next;
    }
}
