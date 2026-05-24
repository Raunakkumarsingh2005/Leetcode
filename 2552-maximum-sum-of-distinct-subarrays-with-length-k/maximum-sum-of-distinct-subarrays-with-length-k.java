class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        long maxSum = 0;
        long sum = 0;

        for (int i = 0; i < k ; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //check first window
        if (map.size() == k) {
            maxSum = sum;
        }

        // sliding window
        for (int i = k ; i < nums.length ; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            int remove = nums[i-k];

            sum -= remove;
            map.put(remove, map.get(remove)-1);

            if (map.get(remove) == 0) {
                map.remove(remove);
            }
    

            if (map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}