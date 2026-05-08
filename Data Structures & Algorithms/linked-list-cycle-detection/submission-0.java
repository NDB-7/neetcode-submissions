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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (head.next != null) {
            set.add(head);
            if (set.contains(head.next)) return true;
            head = head.next;
        }

        return false;
    }
}

/*

Cycle: tail.next = node, index = node's index (from 0)
No cycle: tail.next = null, index = -1

*/