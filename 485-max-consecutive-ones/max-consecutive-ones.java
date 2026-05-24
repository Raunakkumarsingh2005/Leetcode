class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int low = 0;
        int high = 0;
        int n = nums.length;

        int count = 0;
        int maxCount = 0;

        while (high < n) {
           

            while (high < n && nums[high] == 0) {
                high++;
                low = high;
            }

            if (high == n) {
                break;
            }

            count = high - low + 1;
            maxCount = Math.max(count, maxCount);

            high++;
            
        }

        return maxCount;
    }
}