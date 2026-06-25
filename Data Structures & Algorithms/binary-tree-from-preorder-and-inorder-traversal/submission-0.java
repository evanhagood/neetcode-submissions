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

// T O(n^2), S O(n)
// here, finding the root node (mid) takes O(n) time and we have the overhead of creating new arrays each function call.
// you can do this better by using a map + left and right pointers
// you can do this optimally by using DFS and a limit value that tells us when to stop building the left tree instead of creating and passing arrays.
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // in preorder traversal, the first node is ALWAYS the root node.
        TreeNode root = new TreeNode(preorder[0]);

        // now that we know the root node, we find it in the inorder array
        // values to the left of this pivot point are part of the left subtree, and to the right are the right subtree (incl the pivot itself)
        int mid = -1;
        for(int i = 0; i < inorder.length; i++) {
            if(preorder[0] == inorder[i]) {
                mid = i;
                break;
            }
        }

        // we can recursively construct the binary tree by passing the sub-trees back into buildTree()
        // remember: inorder: left of mid is left-subtree, right is the right subtree
        // and then we just pass the different halves of preorder to keep knowing the root nodes for each tree.
        int[] inorderSubTree = Arrays.copyOfRange(inorder, 0, mid);
        int[] preorderSubTree = Arrays.copyOfRange(preorder, 1, mid + 1);
        root.left = buildTree(preorderSubTree, inorderSubTree);

        inorderSubTree = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        preorderSubTree = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        root.right = buildTree(preorderSubTree, inorderSubTree);

        return root;
    }
}
