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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxVal) {
        int res = 0;
        if (root == null) return res;
        if (root.val >= maxVal) {
            res = 1;
            maxVal = root.val;
        }
        res += dfs(root.left, maxVal);
        res += dfs(root.right, maxVal);
        return res;
    }
}
