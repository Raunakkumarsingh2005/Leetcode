class Solution {
    public int maxProduct(int[] nums) {
        int bestending2 = 0;
        int bestending = nums[0];
        int result = nums[0];

        for (int i = 1 ; i < nums.length ; i++) {
            int v1 = bestending * nums[i];
            int v2 = nums[i];
            int v3 = bestending2 * nums[i];

            bestending = Math.max(v1, Math.max(v2, v3));
            bestending2 = Math.min(v1, Math.min(v2, v3));
            result = Math.max(result, bestending);
        }

        return result;
    }
}