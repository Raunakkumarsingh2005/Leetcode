class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int i : weights) {
            low = Math.max(low, i);
            high += i;
        }

        while (low <= high) {
            int mid = low + (high-low) / 2;

            if (isValidCapacity(weights, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean isValidCapacity(int[] weights, int days, int mid) {
        long capacity = 0;
        int count = 1;

        for (int i : weights) {
            if (capacity + i > mid) {
                count++;
                capacity = i;
            } else {
                capacity += i;
            }
        }

        if (count > days) {
            return false;
        }

        return true;
    }
}