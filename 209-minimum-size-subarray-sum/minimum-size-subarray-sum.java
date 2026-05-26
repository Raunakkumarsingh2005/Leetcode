class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int high = 0;
        int sum = 0;
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        while (high < n) {
            sum += nums[high];

            while (sum >= target) {
                minLength = Math.min(minLength, high-low+1);
                sum -= nums[low];
                low++;
            }

            high++;
        }

        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }

        return minLength;
    }
}