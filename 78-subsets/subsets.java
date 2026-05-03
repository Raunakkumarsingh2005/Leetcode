class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // not take
        backtrack(idx + 1, nums, curr, res);

        // take
        curr.add(nums[idx]);
        backtrack(idx + 1, nums, curr, res);
        curr.remove(curr.size() - 1);
    }
}