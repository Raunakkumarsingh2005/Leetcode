class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int bestEnding = nums[0];
        int result = nums[0];
        int bestending2 = nums[0];

        if (nums.length <= 1) {
            return Math.max(result, Math.max(Math.abs(bestEnding), Math.abs(bestending2)));
        }

        for (int i = 1 ; i < nums.length; i++) {
            int v1 = bestEnding + nums[i];
            int v2 = nums[i];
            int v3 = bestending2 + nums[i];

            bestEnding = Math.max(v1, Math.max(v2, v3));
            bestending2 = Math.min(v1, Math.min(v2, v3));

            result = Math.max(result, Math.max(Math.abs(bestEnding), Math.abs(bestending2)));
        }

        return result;
    }
}