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
    int minHeight = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        depth(root, 0);
        if (root == null) {
            return 0;
        }
        return minHeight;
    }

    public void depth(TreeNode node, int count) {
        if (node == null) {
            return;
        }

        count++;
        if (node.left == null && node.right == null) {
            minHeight = Math.min(count, minHeight);
        }

        depth(node.left, count);
        depth(node.right, count);
    }
}