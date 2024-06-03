package questions.n567_checkInclusion;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[128];
        int[] window = new int[128];
        char[] s1Chs = s1.toCharArray();
        int count = 0;
        int left = 0, right = 0, match = 0;
        for (char ch : s1Chs) {
            if (need[ch] == 0) {
                count++;
            }
            need[ch]++;
        }
        while (right < s2.length()) {
            char c = s2.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内一系列的数据更新
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    match++;
                }
            }
            if (match == count) {
                return true;
            }
            // 检查左侧边界是否收缩，因为是s1的排列，因此窗口的大小一定要等于s1
            if (right - left == s1.length()) {
                char d = s2.charAt(left);
                // 缩小窗口
                left++;
                // 进行一系列的更新数据更新
                if (need[d] > 0) {
                    if (window[d] == need[d]) {
                        match--;
                    }
                    window[d]--;
                }
            }
        }
        return false;
    }
}