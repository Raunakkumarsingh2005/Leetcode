class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        if (nums.length == 1) {
            return 0;
        }
        
        while (low <= high) {
            int mid = low + (high-low) / 2;
            int left = mid-1;
            int right = mid+1;

            if ((left < 0 || nums[mid] > nums[left]) && (right > nums.length-1 || nums[mid] > nums[right])) {
                return mid;
            } else if (nums[mid+1] > nums[mid]) {
                low = mid+1;
            } else if (nums[mid-1] > nums[mid]) {
                high = mid-1;
            }
        }

        return -1;
    }
}