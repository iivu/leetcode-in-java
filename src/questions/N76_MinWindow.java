package questions;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
class SolutionN76 {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];
        char[] tChs = t.toCharArray();
        int count = 0;
        int left = 0, right = 0, match = 0;
        int start = 0, minLen = Integer.MAX_VALUE;
        for (char ch : tChs) {
            if (need[ch] == 0) {
                count++;
            }
            need[ch]++;
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内一系列的数据更新
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    match++;
                }
            }
            // 检查左侧边界是否收缩
            while (match == count) {
                // 最小覆盖子串更新
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char d = s.charAt(left);
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
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}