class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i <= nums.length-1; i++) {
            if (nums[i] >= k) {
                continue;
            }
            
            count++;
            if (i == nums.length-1) break;

            int product = nums[i];
            for (int j = i+1; j <= nums.length-1; j++) {
                product = product * nums[j];

                if (product < k) {
                    count++;
                    continue;
                }else {
                    break;
                }
            }

        }

        return count;
    }
}