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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null) queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode current = queue.poll();

                if(current != null) {
                    currentLevel.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
            if(currentLevel.size() > 0) {
                result.add(currentLevel);
            }
        }
        return result;
    }
}
