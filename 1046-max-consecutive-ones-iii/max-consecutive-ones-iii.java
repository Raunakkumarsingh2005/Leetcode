class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int high = 0;

        int n = nums.length;
        int zeros = 0;
        int count = 0;
        int maxCount = Integer.MIN_VALUE;

        while (high < n) {
            if (nums[high] == 0 && zeros < k) {
                zeros += 1;
                count += 1;
                high++;
            } else if (nums[high] == 0 && zeros >= k) {
                while (zeros >= k) {
                    if (nums[low] == 0) {
                        zeros--;
                    }
                    low++;
                    count--;
                }
            } else {
                count++;
                high++;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}