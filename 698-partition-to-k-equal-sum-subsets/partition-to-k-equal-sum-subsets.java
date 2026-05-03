class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int x : nums) sum += x;

        if (sum % k != 0) return false;

        int target = sum / k;
        Arrays.sort(nums);

        boolean[] vis = new boolean[nums.length];

        return dfs(nums, vis, k, 0, 0, target);
    }

    private boolean dfs(int[] nums, boolean[] vis, int k, int curSum, int start, int target) {
        if (k == 0) return true;

        if (curSum == target) {
            return dfs(nums, vis, k - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (vis[i]) continue;
            if (curSum + nums[i] > target) continue;

            vis[i] = true;

            if (dfs(nums, vis, k, curSum + nums[i], i + 1, target)) return true;

            vis[i] = false;
        }

        return false;
    }
}