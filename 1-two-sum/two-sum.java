class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i <= nums.length-1; i++) {
            int second = target - nums[i];
            if (map.containsKey(second)) {
                arr[0] = map.get(second);
                arr[1] = i;
                break;
            }

            map.put(nums[i], i);
        }

        return arr;
    }
}