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
    public boolean isBalanced(TreeNode root) {
        return balanced(root);
    }

    public Boolean balanced(TreeNode node) {
        if (node == null) {
            return true;
        }

        Boolean left = balanced(node.left);
        Boolean right = balanced(node.right);

        int range = height(node.left) - height(node.right);

        return (range >= -1 && range <= 1) && left && right;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}