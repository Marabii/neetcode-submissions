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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Handle current level:
            int currLevelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>(currLevelSize);

            for (int i = 0; i < currLevelSize; i++) {
                TreeNode levelItem = queue.poll();
                currLevel.add(levelItem.val);

                if (levelItem.left != null) {
                    queue.add(levelItem.left);
                }

                if (levelItem.right != null) {
                    queue.add(levelItem.right);
                }
            }

            result.add(currLevel);

        }

        return result;
    }
}
