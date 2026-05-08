/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copyDummy = new Node(0);
        Node copyCurr = copyDummy;
        Node curr = head;

        Map<Node, Node> originalToCopy = new HashMap<>();

        // First Pass - Copy values & next
        while (curr != null) {
            copyCurr.next = new Node(curr.val);
            copyCurr = copyCurr.next;
            originalToCopy.put(curr, copyCurr);
            curr = curr.next;
        }

        curr = head;
        copyCurr = copyDummy;

        // Second Pass - Copy randoms
        while (curr != null) {
            copyCurr = copyCurr.next;
            copyCurr.random = originalToCopy.getOrDefault(curr.random, null);
            curr = curr.next;
        }

        return copyDummy.next;
    }
}
