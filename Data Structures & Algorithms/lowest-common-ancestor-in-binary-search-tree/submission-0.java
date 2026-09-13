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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode big = p.val > q.val ? p : q;
        TreeNode small = p.val < q.val ? p : q;

        return lowestCommonAncestorHelper(root, small, big);
    }

    public TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode small, TreeNode big) {
        if ((root.val > small.val && root.val < big.val) || (root.val == small.val) || (root.val == big.val)) {
            return root;
        } else if (root.val > small.val && root.val > big.val) {
            return lowestCommonAncestorHelper(root.left, small, big);
        } else if (root.val < small.val && root.val < big.val) {
            return lowestCommonAncestorHelper(root.right, small, big);
        }

        return null;
    }
}
