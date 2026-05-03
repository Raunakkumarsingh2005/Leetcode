class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int idx, int parts, List<String> cur, List<String> res) {
        if (parts == 4 && idx == s.length()) {
            res.add(String.join(".", cur));
            return;
        }

        if (parts == 4 || idx == s.length()) return;

        for (int len = 1; len <= 3; len++) {
            if (idx + len > s.length()) break;

            String part = s.substring(idx, idx + len);

            if (part.startsWith("0") && part.length() > 1) continue;
            if (Integer.parseInt(part) > 255) continue;

            cur.add(part);
            dfs(s, idx + len, parts + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}