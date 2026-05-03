class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        dfs(0, board, n);
        return count;
    }

    private void dfs(int col, char[][] board, int n) {
        if (col == n) {
            count++;
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int r, int c, int n) {
        int i, j;

        for (i = 0; i < c; i++)
            if (board[r][i] == 'Q') return false;

        for (i = r, j = c; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (i = r, j = c; i < n && j >= 0; i++, j--)
            if (board[i][j] == 'Q') return false;

        return true;
    }
}