class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int high = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        while (high < n) {
            while (map.containsKey(s.charAt(high))) {
                map.put(s.charAt(low), map.get(s.charAt(low))-1);

                if (map.get(s.charAt(low)) == 0) {
                    map.remove(s.charAt(low));
                }

                low++;
            }

            map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0)+1);

            high++;

            maxLength = Math.max(map.size(), maxLength);
        }

        return maxLength;
    }
}