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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode rightSide = null;
            for(int i = queue.size(); i > 0; i--) {
                TreeNode current = queue.poll();
                if(current != null) {
                    rightSide = current;
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
            if(rightSide != null) result.add(rightSide.val);
        }

        return result;
    }
}
