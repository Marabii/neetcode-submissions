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
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfsHelper(root, res);
        return res.get(k - 1);
    }

    private static void dfsHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            dfsHelper(root.left, res);
            res.add(root.val);
            dfsHelper(root.right, res);
        }
    }
}
