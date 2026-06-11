class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high-low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
                if (low == high) break;
            }
        }

        int r1 = binarySearch(nums, target, 0, mid-1);
        int r2 = binarySearch(nums, target, mid, nums.length-1);

        return r1 == -1 ? r2 : r1;
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high-low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}