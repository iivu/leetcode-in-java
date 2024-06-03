package questions.n424_characterReplacement;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] windowCount = new int[26];
        int windowMaxCount = 0;
        int l = 0, r = 0;
        int ans = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            r++;
            windowCount[ch - 'A']++;
            windowMaxCount = Math.max(windowMaxCount, windowCount[ch - 'A']);
            while (r - l - windowMaxCount > k) {
                char out = s.charAt(l);
                l++;
                windowCount[out - 'A']--;
                // ?? 为什么不用更新windowMaxCount
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}