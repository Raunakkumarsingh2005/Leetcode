class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        Boolean ans = true;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    public boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}