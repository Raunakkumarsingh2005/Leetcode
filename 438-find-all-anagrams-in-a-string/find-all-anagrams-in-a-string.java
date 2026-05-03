class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int left = 0, right = 0;
        int n = s.length(), k = p.length();

        while (right < n) {
            window[s.charAt(right) - 'a']++;

            if (right - left + 1 > k) {
                window[s.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(window, pCount)) {
                result.add(left);
            }

            right++;
        }

        return result;
    }
}