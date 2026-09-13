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
        public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if (currNode != null) {
                    // Add left child:
                    if (currNode.left != null && !visited.contains(currNode.left)) {
                        queue.add(currNode.left);
                        visited.add(currNode.left);
                    }

                    // Add right child:
                    if (currNode.right != null && !visited.contains(currNode.right)) {
                        queue.add(currNode.right);
                        visited.add(currNode.right);
                    }

                    if (i == levelSize - 1) {
                        result.add(currNode.val);
                    }

                }
            }
        }

        return result;
    }
}
