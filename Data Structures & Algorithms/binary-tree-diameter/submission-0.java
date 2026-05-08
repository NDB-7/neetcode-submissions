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
    public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> sums = new ArrayList<>();
        dfs(root, sums);

        return Collections.max(sums);
    }

    private int dfs(TreeNode node, List<Integer> sums) {
        int lDepth = 0, rDepth = 0;
        if (node.left != null) lDepth = 1 + dfs(node.left, sums);
        if (node.right != null) rDepth = 1 + dfs(node.right, sums);

        sums.add(lDepth + rDepth);

        return Math.max(lDepth, rDepth);
    }
}
