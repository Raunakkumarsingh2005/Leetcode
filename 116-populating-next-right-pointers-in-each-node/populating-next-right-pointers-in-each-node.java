/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node node = root;

        if (root == null) {
            return root;
        }

        while (node.left != null) {
            Node node2 = node;
            Node node1 = node2.left;

            while (node2 != null) {

                node1.next = node2.right;
                node1 = node1.next;
                if (node2.next == null) {
                    node1.next = null;
                    node2 = node2.next;
                } else {
                    node2 = node2.next;
                    node1.next = node2.left;
                    node1 = node1.next;
                }
            }
            node = node.left;
        }
        return root;
    }
}