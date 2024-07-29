package questions.n38_countAndSay;

public class Solution2 {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            ans = encode(ans);
        }
        return ans;
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
