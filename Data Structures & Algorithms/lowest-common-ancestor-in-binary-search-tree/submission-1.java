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
        TreeNode low = null;
        TreeNode high = null;

        if (p.val >= q.val) {
            low = q;
            high = p;
        } else {
            low = p;
            high = q;
        }

        return lowestCommonAncestorHelper(root, low, high);
    }

    private TreeNode lowestCommonAncestorHelper(TreeNode node, TreeNode low, TreeNode high) {
        if (low.val <= node.val && node.val <= high.val) {
            return node;
        }

        if (low.val <= node.val && high.val <= node.val) {
            return lowestCommonAncestorHelper(node.left, low, high);
        }

        return lowestCommonAncestorHelper(node.right, low, high);
    }
}
