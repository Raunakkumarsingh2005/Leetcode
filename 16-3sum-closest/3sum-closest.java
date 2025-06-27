class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1; 
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                int diff = Math.abs(target - sum);

                if (minDiff > diff) {
                    minDiff = diff;
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }

        return closestSum;
    }
}