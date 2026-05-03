class Solution {
    int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    union(i, map.get(email));
                }
            }
        }

        Map<Integer, List<String>> res = new HashMap<>();

        for (String email : map.keySet()) {
            int root = find(map.get(email));
            res.putIfAbsent(root, new ArrayList<>());
            res.get(root).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int key : res.keySet()) {
            List<String> list = res.get(key);
            Collections.sort(list);
            list.add(0, accounts.get(key).get(0));
            ans.add(list);
        }

        return ans;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) parent[pa] = pb;
    }
}