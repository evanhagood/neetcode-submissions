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
    int max = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    private void dfs(TreeNode root, int depth) {
        if(root == null) return;

        depth = depth + 1;
        max = Math.max(depth, max);

        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}
