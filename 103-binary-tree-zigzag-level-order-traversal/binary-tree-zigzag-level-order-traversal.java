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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> sublist = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode node;
                if (reverse == false) {
                    node = queue.pollLast();
                    sublist.add(node.val);
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }

                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                }

                if (reverse == true) {
                    node = queue.pollFirst();
                    sublist.add(node.val);

                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }

                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                }
            }
            result.add(sublist);
            reverse = !reverse;
        }

        return result;
    }
}