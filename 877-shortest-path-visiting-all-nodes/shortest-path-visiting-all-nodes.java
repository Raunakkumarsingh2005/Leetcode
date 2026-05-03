class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][1 << n];

        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i, 0});
            vis[i][1 << i] = true;
        }

        int target = (1 << n) - 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], mask = cur[1], dist = cur[2];

            if (mask == target) return dist;

            for (int nei : graph[node]) {
                int nextMask = mask | (1 << nei);

                if (!vis[nei][nextMask]) {
                    vis[nei][nextMask] = true;
                    q.offer(new int[]{nei, nextMask, dist + 1});
                }
            }
        }

        return -1;
    }
}