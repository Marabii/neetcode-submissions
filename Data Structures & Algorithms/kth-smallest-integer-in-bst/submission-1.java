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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        kthSmallestHelper(root, k, nums);
        return nums.get(k - 1);
    }

    private void kthSmallestHelper(TreeNode root, int k, List<Integer> nums) {
        if (root == null || nums.size() == k) {
            return;
        }

        kthSmallestHelper(root.left, k, nums);
        nums.add(root.val);
        kthSmallestHelper(root.right, k, nums);
    }
}
