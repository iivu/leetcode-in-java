package questions;

import java.util.Map;

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