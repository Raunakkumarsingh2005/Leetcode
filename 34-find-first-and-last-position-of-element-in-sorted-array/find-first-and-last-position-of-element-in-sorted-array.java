class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstIndex(nums, target);
        int last = lastIndex(nums, target);

        return new int[] {first, last};
    }

    public int firstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target) {
                result = mid;
                high = mid-1;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        return result;
    }

    public int lastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target) {
                result = mid;
                low = mid+1;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        return result;
    }
}