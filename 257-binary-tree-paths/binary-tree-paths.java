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
    ArrayList<String> list = new  ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, new StringBuilder());
        return list;
    }

    public void helper(TreeNode node, StringBuilder str) {
        if (node == null) {
            return;
        }

        int len = str.length();

        if (len > 0) {
            str.append("->");
        }

        str.append(node.val);

        helper(node.left, str);
        helper(node.right, str);

        if (node.left == null && node.right == null) {
            list.add(str.toString());
        }

        str.setLength(len);
    }
}