class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] vis = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], t = cur[2];

            if (x == n - 1 && y == n - 1) return t;

            if (vis[x][y]) continue;
            vis[x][y] = true;

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                pq.offer(new int[]{nx, ny, Math.max(t, grid[nx][ny])});
            }
        }

        return -1;
    }
}