class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int low = 0;
        int high = 0;
        int n = s2.length();
        Boolean res = false;
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0)+1);
        }

        while (high < n) {
            map.put(s2.charAt(high), map.getOrDefault(s2.charAt(high), 0)+1);

            while (high - low + 1 > s1.length()) {
                char leftChar = s2.charAt(low);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                low++;
            }

            if (map.equals(s1Map)) {
                res = true;
            }

            high++;
        }

        return res;
    }

}