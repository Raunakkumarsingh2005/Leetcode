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
    // public boolean isValidBST(TreeNode root) {
    //     return isValid(root, null, null);
    // }

    // public Boolean isValid(TreeNode node, Integer low, Integer high) {
    //     if (node == null) {
    //         return true;
    //     }

    //     if (low != null && low <= node.val) {
    //         return false;
    //     }

    //     if (high != null && high >= node.val) {
    //         return false;
    //     }

    //     Boolean left = isValid(node.left, low, node.val);
    //     Boolean right = isValid(node.right, node.val, high);

    //     return left && right;
    // }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
  }
  public boolean helper(TreeNode node, Integer low, Integer high) {
    if (node == null) {
      return true;
    }

    if (low != null && node.val <= low) {
      return false;
    }

    if(high != null && node.val >= high) {
      return false;
    }

    boolean leftTree = helper(node.left, low, node.val);
    boolean rightTree = helper(node.right, node.val, high);

    return leftTree && rightTree;
    
  }
}