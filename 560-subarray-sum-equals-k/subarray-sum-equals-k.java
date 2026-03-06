class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0,1);

        for (int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) count += map.get(sum-k);
            if (map.containsKey(sum)) {
                int freq = map.get(sum);
                freq++;
                map.put(sum, freq);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }
}