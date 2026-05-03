class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;

        for (int p : piles) {
            right = Math.max(right, p);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0; // FIX: use long to avoid overflow

        for (int p : piles) {
            hours += (p + speed - 1) / speed;
        }

        return hours <= h;
    }
}