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
        return dfs(root)[0] == 1;
    }

    /***
    * Depth-First Search impl that tracks if all sub-trees are balanced.
    *
    * returns an integer array of the form [balanced, height of tree]
    * during the execution of this method, the inner steps return the height of their respective sub-trees
    * and their height.
    */
    private int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[] {1, 0}; // an empty tree is balanced
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = (left[0] == 1 && right[0] == 1) &&    // check if any sub-tree came back unbalanced
                            (Math.abs(left[1] - right[1]) <= 1); // check if both right and left sub-trees are balanced
        int height = 1 + Math.max(left[1], right[1]);

        return new int[] {balanced ? 1 : 0, height};
    }


}
