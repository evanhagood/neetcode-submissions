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
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        inorderDFS(root, tmp);
        return tmp[1];
    }

    private void inorderDFS(TreeNode root, int[] count) {
        if (root == null) return;

        inorderDFS(root.left, count);

        if (count[0] == 0) {
            return;
        } else {
            count[0]--;
            count[1] = root.val;
            if (count[0] == 0) return;
        }

        inorderDFS(root.right, count);
    }
}
