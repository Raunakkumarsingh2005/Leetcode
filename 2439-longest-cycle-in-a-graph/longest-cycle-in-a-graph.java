class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] vis = new int[n];
        int[] time = new int[n];

        int ans = -1;
        int timer = 1;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                ans = Math.max(ans, dfs(edges, i, vis, time, timer));
            }
        }

        return ans;
    }

    private int dfs(int[] edges, int node, int[] vis, int[] time, int timer) {
        if (node == -1) return -1;

        if (vis[node] == 1) {
            return timer - time[node];
        }

        if (vis[node] == 2) return -1;

        vis[node] = 1;
        time[node] = timer;

        int res = dfs(edges, edges[node], vis, time, timer + 1);

        vis[node] = 2;
        return res;
    }
}