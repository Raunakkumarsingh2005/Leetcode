class Solution {
    int timer = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (List<Integer> e : connections) {
            adj.get(e.get(0)).add(e.get(1));
            adj.get(e.get(1)).add(e.get(0));
        }

        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];

        List<List<Integer>> res = new ArrayList<>();

        dfs(0, -1, adj, vis, disc, low, res);

        return res;
    }

    private void dfs(int u, int parent, List<List<Integer>> adj,
                     boolean[] vis, int[] disc, int[] low,
                     List<List<Integer>> res) {

        vis[u] = true;
        disc[u] = low[u] = ++timer;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (!vis[v]) {
                dfs(v, u, adj, vis, disc, low, res);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}