class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {
            int target = -nums[i];
            int left = 0;
            int right = nums.length-1;
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while (left < right) {
                if (left == i) {
                    left++;
                } else if (right == i) {
                    right--;
                }

                else if (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> arr = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                        Collections.sort(arr);
                        set.add(arr);
                        left++;
                        right--;
                    }
                }

            }
        }

        List<List<Integer>> list = new ArrayList(set);
        return list;
    }
}