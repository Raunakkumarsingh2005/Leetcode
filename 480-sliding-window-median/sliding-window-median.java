// Sliding Window Median (Optimized - No TLE)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> res = new ArrayList<>();
        TreeMap<Integer, Integer> left = new TreeMap<>();  // max side
        TreeMap<Integer, Integer> right = new TreeMap<>(); // min side

        int leftSize = 0, rightSize = 0;

        for (int i = 0; i < nums.length; i++) {
            if (left.isEmpty() || nums[i] <= left.lastKey()) {
                left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);
                leftSize++;
            } else {
                right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
                rightSize++;
            }

            // balance
            while (leftSize > rightSize + 1) {
                int key = left.lastKey();
                remove(left, key);
                leftSize--;
                right.put(key, right.getOrDefault(key, 0) + 1);
                rightSize++;
            }
            while (leftSize < rightSize) {
                int key = right.firstKey();
                remove(right, key);
                rightSize--;
                left.put(key, left.getOrDefault(key, 0) + 1);
                leftSize++;
            }

            if (i >= k) {
                int out = nums[i - k];
                if (left.containsKey(out)) {
                    remove(left, out);
                    leftSize--;
                } else {
                    remove(right, out);
                    rightSize--;
                }

                // rebalance after removal
                while (leftSize > rightSize + 1) {
                    int key = left.lastKey();
                    remove(left, key);
                    leftSize--;
                    right.put(key, right.getOrDefault(key, 0) + 1);
                    rightSize++;
                }
                while (leftSize < rightSize) {
                    int key = right.firstKey();
                    remove(right, key);
                    rightSize--;
                    left.put(key, left.getOrDefault(key, 0) + 1);
                    leftSize++;
                }
            }

            if (i >= k - 1) {
                if (k % 2 == 1) {
                    res.add((double) left.lastKey());
                } else {
                    res.add(((double) left.lastKey() + right.firstKey()) / 2);
                }
            }
        }

        double[] ans = new double[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }

    private void remove(TreeMap<Integer, Integer> map, int key) {
        if (map.get(key) == 1) map.remove(key);
        else map.put(key, map.get(key) - 1);
    }
}