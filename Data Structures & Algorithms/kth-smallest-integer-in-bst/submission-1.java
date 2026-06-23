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


// The same thing as my orig inorder DFS solution but we do not have to make an entire sorted array
// since inorder traversal already visits nodes in sorted order, once we visit the kth node, that is our answer
// all we have to do, then, is count how many nodes we've visited.
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        inorderDFS(root, tmp);
        return tmp[1];
    }

    private void inorderDFS(TreeNode root, int[] tmp) {
        if(root == null) {
            return;
        }

        inorderDFS(root.left, tmp);

        if(tmp[0] == 0) {
            return;
        }
        tmp[0] -= 1;
        if(tmp[0] == 0) {
            tmp[1] = root.val;
            return;
        }

        inorderDFS(root.right, tmp);
    }
}
