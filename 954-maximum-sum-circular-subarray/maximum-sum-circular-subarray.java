class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int bestending = nums[0];
        int result = nums[0];
        int total = nums[0];

        for (int i = 1 ; i < nums.length ; i++) {
            int v1 = bestending + nums[i];
            int v2 = nums[i];

            bestending = Math.min(v1, v2);
            result = Math.min(bestending, result);

            total += nums[i];
        }

        int maxSum = maximum(nums);
        int circularSum = total - result;

        if (maxSum > 0) {
            return Math.max(maxSum, circularSum);
        }

        return maxSum;
    }

    public int maximum(int[] nums) {
        int bestending = nums[0];
        int result = nums[0];
        int total = nums[0];

        for (int i = 1 ; i < nums.length ; i++) {
            int v1 = bestending + nums[i];
            int v2 = nums[i];

            bestending = Math.max(v1, v2);
            result = Math.max(bestending, result);
        }

        return result;

    }
}