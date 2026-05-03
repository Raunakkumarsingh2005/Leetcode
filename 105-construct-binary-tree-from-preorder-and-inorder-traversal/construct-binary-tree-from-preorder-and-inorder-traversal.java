class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] pre, int ps, int pe,
                           int[] in, int is, int ie,
                           Map<Integer, Integer> map) {
        if (ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(pre[ps]);
        int idx = map.get(root.val);
        int leftSize = idx - is;

        root.left = build(pre, ps + 1, ps + leftSize,
                          in, is, idx - 1, map);

        root.right = build(pre, ps + leftSize + 1, pe,
                           in, idx + 1, ie, map);

        return root;
    }
}