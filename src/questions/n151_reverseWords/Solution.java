package questions.n151_reverseWords;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
class Solution {
    public String reverseWords(String s) {
        char[] chars = getChars(s);
        int len = chars.length;
        reverse(chars, 0, len - 1);
        for (int i = 0; i < len; ) {
            for (int j = i; j < len; j++) {
                if (j + 1 == len || chars[j + 1] == ' ') {
                    reverse(chars, i, j);
                    i = j + 2;
                    break;
                }
            }
        }
        return new String(chars);
    }

    private char[] getChars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                sb.append(ch);
            } else {
                if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(ch);
                }
            }
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString().toCharArray();
    }

    private void reverse(char[] chars, int s, int e) {
        while (s < e) {
            char temp = chars[s];
            chars[s] = chars[e];
            chars[e] = temp;
            s++;
            e--;
        }
    }
}