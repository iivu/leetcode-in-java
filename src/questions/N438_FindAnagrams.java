package questions;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
class SolutionN438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[26];
        int[] window = new int[26];
        int left = 0, right = 0;
        int match = 0, totalMatch = 0;
        List<Integer> ans = new ArrayList<>();
        for (char ch : p.toCharArray()) {
            if (need[ch - 'a'] == 0) {
                totalMatch++;
            }
            need[ch - 'a']++;
        }
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (need[ch - 'a'] > 0) {
                window[ch - 'a']++;
                if (window[ch - 'a'] == need[ch - 'a']) {
                    match++;
                }
            }
            if (match == totalMatch) {
                ans.add(left);
            }
            if (right - left == p.length()) {
                char d = s.charAt(left);
                left++;
                if (need[d - 'a'] > 0) {
                    if (window[d - 'a'] == need[d - 'a']) {
                        match--;
                    }
                    window[d - 'a']--;
                }
            }
        }
        return ans;
    }
}