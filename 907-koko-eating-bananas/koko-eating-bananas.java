class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1;
        int high = piles[piles.length-1];

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (isValidEatingSpeed(piles, h, mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;
    }

    public boolean isValidEatingSpeed(int[] piles, int h, int mid) {
        long sum = 0;
        for (int i : piles) {
            sum += Math.ceilDiv(i, mid);
        }

        if (sum <= h) {
            return true;
        }

        return false;
    }
}