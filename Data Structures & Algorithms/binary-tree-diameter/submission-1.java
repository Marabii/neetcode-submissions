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
        return Math.max(Math.max(diameterOfBinaryTreeHelper(root.left), diameterOfBinaryTreeHelper(root.right)),
                diameterOfBinaryTreeHelper(root));
    }

    private int diameterOfBinaryTreeHelper(TreeNode root) {
                if (root == null) return 0;
        return maxDepth(root.left) + maxDepth(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
