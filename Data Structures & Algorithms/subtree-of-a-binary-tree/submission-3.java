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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSameTree(root, subRoot) || (root != null ? isSubtree(root.left, subRoot)
                : false) || (root != null ? isSubtree(root.right, subRoot) : false);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            if (q == null) {
                return true;
            }
            return false;
        }

        if (q == null) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean curr = p.val == q.val;
        boolean right = isSameTree(p.right, q.right);
        return left && curr && right;
    }
}
