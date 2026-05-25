class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int high = 0;
        int low = 0;
        int n = nums.length;
        int product = 1;
        int count = 0;

        if (k <= 1) {
            return 0;
        }

        while (high < n) {
            product *= nums[high];

            while (product >= k) {
                product /= nums[low];
                low++;
            }

            count += high-low+1;
            high++;
        }

        return count;
    }
}