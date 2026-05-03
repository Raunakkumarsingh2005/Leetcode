class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);
        return res;
    }

    private void dfs(int[][] g, int node, List<Integer> path, List<List<Integer>> res) {
        if (node == g.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int nei : g[node]) {
            path.add(nei);
            dfs(g, nei, path, res);
            path.remove(path.size() - 1);
        }
    }
}