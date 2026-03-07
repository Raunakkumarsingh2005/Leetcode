class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        int count = 0;

        map.put(0, 1);

        for (int i : nums) {
            sum += i;
            int rem = (sum % k + k) % k;

            if (map.containsKey(rem)) {
                int temp = map.get(rem);
                count += temp;
                map.put(rem, temp+1);
            } else {
                map.put(rem, 1);
            }
        }

        return count;
    }
}