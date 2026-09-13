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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] currHeadIndex = { 0 };
        return buildTreeHelper(Arrays.stream(preorder).boxed().collect(Collectors.toList()),
                Arrays.stream(inorder).boxed().collect(Collectors.toList()), currHeadIndex);
    }

    private TreeNode buildTreeHelper(List<Integer> preorder, List<Integer> inorder, int[] currHeadIndex) {

        if (currHeadIndex[0] == preorder.size())
            return null;

        int val = preorder.get(currHeadIndex[0]);
        TreeNode root = new TreeNode(val);

        LeftRight leftRight = getLeftRight(preorder.get(currHeadIndex[0]), inorder);
        currHeadIndex[0]++;

        if (leftRight.left.isEmpty()) {
            root.left = null;
        } else {
            root.left = buildTreeHelper(preorder, leftRight.left, currHeadIndex);
        }

        if (leftRight.right.isEmpty()) {
            root.right = null;
        } else {
            root.right = buildTreeHelper(preorder, leftRight.right, currHeadIndex);
        }

        return root;
    }

    private LeftRight getLeftRight(int currHeadVal, List<Integer> inorder) {
        int indexOfCurrHead = inorder.indexOf(currHeadVal);
        return new LeftRight(new ArrayList<>(inorder.subList(0, indexOfCurrHead)),
                new ArrayList<>(inorder.subList(indexOfCurrHead + 1, inorder.size())));
    }

    private record LeftRight(List<Integer> left, List<Integer> right) {

    }
}
