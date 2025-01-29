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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    public int maxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftVal = maxPath(node.left);
        int rightVal = maxPath(node.right);

        leftVal = Math.max(0, leftVal);
        rightVal = Math.max(0, rightVal);

        int sum = leftVal + rightVal + node.val;

        max = Math.max(sum, max);

        return Math.max(leftVal, rightVal) + node.val;
    }
}