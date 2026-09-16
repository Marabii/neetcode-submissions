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
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, root.val);
    }

    private int goodNodesHelper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int newMax = Math.max(root.val, max);
        int curr = 0;

        if (root.val >= max) {
            curr++;
        }

        return curr + goodNodesHelper(root.left, newMax) + goodNodesHelper(root.right, newMax);
    }
}
