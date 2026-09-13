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
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBSTHelper(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        return (root.val > min && root.val < max)
                && ((root.left != null) ? isValidBSTHelper(root.left, min, root.val) : true)
                && ((root.right != null) ? isValidBSTHelper(root.right, root.val, max) : true);
    }
}
