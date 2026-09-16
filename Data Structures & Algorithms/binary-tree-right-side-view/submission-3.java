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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Handle current level:
            int currLevelSize = queue.size();
            result.add(queue.peek().val);

            for (int i = 0; i < currLevelSize; i++) {
                TreeNode levelItem = queue.poll();

                if (levelItem.right != null) {
                    queue.add(levelItem.right);
                }

                if (levelItem.left != null) {
                    queue.add(levelItem.left);
                }

            }
        }

        return result;
    }
}
