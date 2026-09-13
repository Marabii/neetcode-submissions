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
        int[] result = { 0 };

        diameterOfBinaryTreeHelper(root, result);

        return result[0];
    }

    public void diameterOfBinaryTreeHelper(TreeNode root, int[] result) {
        if (root == null) {
            return;
        }
        int heightLeft = maxHeight(root.left);
        int heightRight = maxHeight(root.right);
        result[0] = Math.max(heightLeft + heightRight, result[0]);
        diameterOfBinaryTreeHelper(root.left, result);
        diameterOfBinaryTreeHelper(root.right, result);
    }

    public int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
}
