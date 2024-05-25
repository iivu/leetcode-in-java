package questions;

class SolutionN395 {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        for (int i = 1; i <= 26; i++) {
            ans = Math.max(ans, logestKLetterSubstr(s, k, i));
        }
        return ans;
    }

    private int logestKLetterSubstr(String s, int k, int n) {
        // 记录每个字符出现的次数
        char[] windowCount = new char[26];
        // 记录窗口内的字符种类
        int unique = 0;
        // 记录窗口中有几种字符已经满足要求（出现次数大于等k）
        int valid = 0;
        int l = 0, r = 0;
        int result = 0;
        while (r < s.length()) {
            char ch = s.charAt(r++);
            if (windowCount[ch - 'a'] == 0) {
                unique++;
            }
            windowCount[ch - 'a'] += 1;
            if (windowCount[ch - 'a'] == k) {
                valid++;
            }
            while (unique > n) {
                char out = s.charAt(l++);
                if (windowCount[out - 'a'] == k) {
                    valid--;
                }
                windowCount[out - 'a'] -= 1;
                if (windowCount[out - 'a'] == 0) {
                    unique--;
                }
            }
            if (valid == n) {
                result = Math.max(result, r - l);
            }
        }
        return result;
    }
}