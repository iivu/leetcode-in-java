package questions;

class SolutionN5 {
    private int max = 0;
    private int start = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            // 奇数个数回文
            palindrome(s, i, i);
            // 偶数个数回文
            palindrome(s, i, i + 1);
            if (max == s.length()) {
                return s.substring(start, start + max);
            }
        }
        return s.substring(start, start + max);
    }

    private void palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        int len = r - l - 1;
        if (len > max) {
            max = len;
            start = l + 1;
        }
    }
}