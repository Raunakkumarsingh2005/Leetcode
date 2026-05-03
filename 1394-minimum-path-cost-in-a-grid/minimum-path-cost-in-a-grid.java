class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int min = Integer.MAX_VALUE;

                for (int k = 0; k < n; k++) {
                    int val = dp[i - 1][k]
                            + moveCost[grid[i - 1][k]][j]
                            + grid[i][j];

                    min = Math.min(min, val);
                }

                dp[i][j] = min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m - 1][j]);
        }

        return ans;
    }
}