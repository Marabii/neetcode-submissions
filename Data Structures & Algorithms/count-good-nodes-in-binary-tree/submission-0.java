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
    public static int goodNodes(TreeNode root) {
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(root, root.val));
        int numberOfGoodNodes = 0;

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.treeNode.val >= node.localMaximum)
                numberOfGoodNodes++;
            if (node.treeNode.left != null) {
                stack.add(new Node(node.treeNode.left, Math.max(node.localMaximum, node.treeNode.left.val)));
            }

            if (node.treeNode.right != null) {
                stack.add(new Node(node.treeNode.right, Math.max(node.localMaximum, node.treeNode.right.val)));
            }

        }

        return numberOfGoodNodes;
    }

    private static class Node {
        public TreeNode treeNode;
        public int localMaximum;

        public Node(TreeNode treeNode, int localMaximum) {
            this.localMaximum = localMaximum;
            this.treeNode = treeNode;
        }
    }

}
