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
    ArrayList<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        for (int i = 0; i < list.size(); i++) {
            if (i == k-1) {
                return list.get(i);
            }
        }
        return 0;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}