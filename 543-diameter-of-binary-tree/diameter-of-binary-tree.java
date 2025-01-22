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
    int Diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return Diameter-1;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        int dia = left + right + 1;
        Diameter = Math.max(dia, Diameter);

        return Math.max(left, right) + 1;
    }
}