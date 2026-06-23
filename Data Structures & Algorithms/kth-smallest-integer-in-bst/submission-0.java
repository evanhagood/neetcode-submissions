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

    // inorder traversal is O(n)
    // Time is O(n) and Space is O(n)
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        System.out.println(res);
        return res.get(k - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
