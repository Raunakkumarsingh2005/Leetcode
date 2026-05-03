class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        for (String w : words) insert(w);

        Set<String> res = new HashSet<>();

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return new ArrayList<>(res);
    }

    private void insert(String w) {
        TrieNode node = root;

        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.child[idx] == null)
                node.child[idx] = new TrieNode();
            node = node.child[idx];
        }

        node.word = w;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, Set<String> res) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#')
            return;

        char ch = board[r][c];
        TrieNode next = node.child[ch - 'a'];

        if (next == null) return;

        if (next.word != null) res.add(next.word);

        board[r][c] = '#';

        dfs(board, r + 1, c, next, res);
        dfs(board, r - 1, c, next, res);
        dfs(board, r, c + 1, next, res);
        dfs(board, r, c - 1, next, res);

        board[r][c] = ch;
    }
}