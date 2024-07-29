package questions.n38_countAndSay;

/**
 * 「外观数列」是一个数位字符串序列，由递归公式定义：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
 * 行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。因此压缩后字符串变为 "23321511"。
 * <p>
 * 给定一个整数 n ，返回 外观数列 的第 n 个元素。
 */
public class Solution1 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return encode(countAndSay(n - 1));
    }

    private String encode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j + 1 < s.length() && s.charAt(j) != s.charAt(j + 1)) {
                    sb.append(j - i + 1);
                    sb.append(s.charAt(j));
                    i = j;
                    break;
                }
                if (j == s.length() - 1) {
                    sb.append(j - i + 1);
                    sb.append(s.charAt(j));
                    i = j;
                }
            }
        }
        return sb.toString();
    }
}
