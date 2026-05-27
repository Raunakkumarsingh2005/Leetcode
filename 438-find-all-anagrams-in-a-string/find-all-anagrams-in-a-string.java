class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int low = 0;
        int high = 0;
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0)+1);
        }

        while (high < n) {
            map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0)+1);

            while (high - low + 1 > p.length()) {
                char leftChar = s.charAt(low);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                low++;
            }

             if (map.equals(pMap)) {
                res.add(low);
            }

            high++;
        }

        return res;
    }
}