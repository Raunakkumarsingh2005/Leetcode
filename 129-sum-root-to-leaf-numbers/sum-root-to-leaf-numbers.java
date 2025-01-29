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
    int finalSum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return finalSum;
    }

    public void helper(TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        sum = sum*10 + node.val;

        if (node.left == null && node.right == null) {
            finalSum += sum;
            return;
        }

        helper(node.left, sum);
        helper(node.right, sum);
    }
}