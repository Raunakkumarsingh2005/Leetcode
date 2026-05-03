// Smallest Range Covering Elements from K Lists
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[]{val, i, 0});
            max = Math.max(max, val);
        }

        int start = 0, end = Integer.MAX_VALUE;

        while (true) {
            int[] cur = pq.poll();
            int val = cur[0], row = cur[1], idx = cur[2];

            if (max - val < end - start) {
                start = val;
                end = max;
            }

            if (idx + 1 == nums.get(row).size()) break;

            int nextVal = nums.get(row).get(idx + 1);
            pq.offer(new int[]{nextVal, row, idx + 1});
            max = Math.max(max, nextVal);
        }

        return new int[]{start, end};
    }
}