class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(nums, vis, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] vis, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;

            vis[i] = true;
            cur.add(nums[i]);

            dfs(nums, vis, cur, res);

            cur.remove(cur.size() - 1);
            vis[i] = false;
        }
    }
}