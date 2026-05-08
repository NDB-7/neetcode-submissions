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
    public boolean isBalanced(TreeNode root) {
        List<Integer> diffs = new ArrayList<>();

        if (root != null) dfs(root, diffs);

        for (int d : diffs) {
            if (Math.abs(d) > 1) return false;
        }

        return true;
    }

    private int dfs(TreeNode node, List<Integer> diffs) {
        int lDepth = 0, rDepth = 0;

        if (node.left != null) lDepth = 1 + dfs(node.left, diffs);
        if (node.right != null) rDepth = 1 + dfs(node.right, diffs);

        diffs.add(lDepth - rDepth);

        return Math.max(lDepth, rDepth);
    }
}
