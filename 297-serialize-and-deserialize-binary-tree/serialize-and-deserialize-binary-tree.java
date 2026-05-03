class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < vals.length) {
            TreeNode node = q.poll();

            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(node.left);
            }
            i++;

            if (i < vals.length && !vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(node.right);
            }
            i++;
        }

        return root;
    }
}