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
    LinkedList<TreeNode> list = new LinkedList<>();
    public void flatten(TreeNode root) {
        preOrder(root);
        create(list);
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        list.add(node);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void create(LinkedList<TreeNode> list) {
        if (list.isEmpty()) {
            return;
        }
        
        TreeNode node = list.remove();
        node.left = null;
        while (!list.isEmpty()) {
            TreeNode node1 = list.remove();
            node1.left = null;
            node.right = node1;
            node = node.right;
        }
    }
}