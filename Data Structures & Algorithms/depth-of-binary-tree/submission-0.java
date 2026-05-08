/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int lDepth = 1, rDepth = 1;

        if (root.left != null) lDepth += maxDepth(root.left);
        if (root.right != null) rDepth += maxDepth(root.right);

        return Math.max(lDepth, rDepth);
    }
}
