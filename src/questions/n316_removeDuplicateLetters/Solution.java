package questions.n316_removeDuplicateLetters;

import java.util.Stack;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        // 用stack保证 字符的出现顺序
        Stack<Character> stack = new Stack<>();
        // 计数数组辅助解决字母序问题
        int[] count = new int[256];
        // 解决重复问题
        boolean[] inStack = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 每遍历一个字母，都应该减掉它的出现次数
            count[ch]--;
            if (inStack[ch]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek()] > 0) {
                char out = stack.pop();
                inStack[out] = false;
            }
            stack.push(ch);
            inStack[ch] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}