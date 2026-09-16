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
    public boolean isValidBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        isValidBSTHelper(root, nums);

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i + 1) <= nums.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void isValidBSTHelper(TreeNode root, List<Integer> nums) {
        if (root == null)
            return;

        isValidBSTHelper(root.left, nums);
        nums.add(root.val);
        isValidBSTHelper(root.right, nums);
    }
}
