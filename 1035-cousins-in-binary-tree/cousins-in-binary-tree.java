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
    public boolean isCousins(TreeNode root, int x, int y) {
        return (!sameParents(root, x, y) && (sameLevel(root, x, 0) == sameLevel(root, y, 0)));
    }

    public Boolean sameParents(TreeNode node, int x, int y) {
        if (node == null) {
            return false;
        }

        if (node.left == null || node.right == null) {
            if (node.left == null ) {
                return sameParents(node.right, x, y);
            }

            if (node.right == null ) {
                return sameParents(node.left, x, y);
            }
        }

        if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x) ) {
            return true;
        }

        return sameParents(node.left, x, y) || sameParents(node.right, x, y);

    }

    public int sameLevel(TreeNode node, int x, int level) {
        if (node == null) {
            return 0;
        }

        if (node.val == x) {
            return level;
        }

        int left = sameLevel(node.left, x, level+1);
        int right = sameLevel(node.right, x, level+1);

        return left + right;
    }
}