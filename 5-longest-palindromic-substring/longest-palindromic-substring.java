class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i);       // odd length
            int len2 = expand(s, i, i + 1);   // even length

            int maxLen = Math.max(len1, len2);

            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);




        // int i = 0;
        // int j = s.length()-1;
        // String str = "";

        // while (i < j) {
        //     if (s.charAt(i) == s.charAt(j)) {
        //         if (j-i >= str.length()) {
        //             str = s.substring(i, j+1);
        //         }
        //         i++;
        //         j--;
        //     } else {
        //         if (isPalindrome(s, i, j-1)) {
        //             return s.substring(i, j);
        //         } else if (isPalindrome(s, i+1, j)) {
        //             return s.substring(i+1, j+1);
        //         } else {
        //             i++;
        //             j--;
        //         }
        //     }
        // }
        // return str;
    }


    public int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }

    // public boolean isPalindrome(String s, int i, int j) {
    //     while (i < j) {
    //         if (s.charAt(i) != s.charAt(j)) {
    //             return false;
    //         }
    //         i++;
    //         j--;
    //     }

    //     return true;
    // }
}