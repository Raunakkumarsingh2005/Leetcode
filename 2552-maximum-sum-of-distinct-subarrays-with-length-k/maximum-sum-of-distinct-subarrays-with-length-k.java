// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
//         HashSet<Integer> set = new HashSet<>();

//         int res = 0;
//         int sum = 0;

//         int i = 0;
//         int j = 0;

//         int n = nums.length;

//         while (high < n) {
//             if (j-i+1 == k) {

//             } else if (j-i+1 > k) {
//                 // shrink window
//             } else if (j-i+1 < k) {

//                 if (set.add(j) == true) {
//                     sum += j;
//                     j++;
//                 } else {
//                     while (set.add(j) != true) {
//                         i++;
//                         set.remove(i);
//                         sum -= i;
//                     }
//                 }
//                 // expand window
//             }
//         }
//      }
// }

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long maxSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Check first window
        if (map.size() == k) {
            maxSum = sum;
        }

        // Sliding window
        for (int i = k; i < nums.length; i++) {

            // Add new element
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // Remove old element
            int remove = nums[i - k];

            sum -= remove;

            map.put(remove, map.get(remove) - 1);

            if (map.get(remove) == 0) {
                map.remove(remove);
            }

            // Check distinct
            if (map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}