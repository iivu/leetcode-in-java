package utils;

public final class RobinKarp {

    public static void main(String[] args) {
        System.out.println(RobinKarp.search("Hello World.", "or"));
    }

    private static final int Q = 1658598167;
    private static final int R = 256;

    private RobinKarp() {
    }

    public static int search(String s, String part) {
        int L = part.length();
        if (L > s.length()) {
            return -1;
        }
        int RL = 1;
        // RL = R ^ (L - 1)
        for (int i = 1; i <= L - 1; i++) {
            RL = (RL * R) % Q;
        }
        int partHash = 0;
        int windowHash = 0;
        for (int i = 0; i < L; i++) {
            partHash = ((partHash * R) % Q + part.charAt(i)) % Q;
        }
        int l = 0, r = 0;
        while (r < s.length()) {
            char ch = s.charAt(r++);
            windowHash = ((windowHash * R) % Q + ch) % Q;
            if (r - l == L) {
                if (windowHash == partHash && part.equals(s.substring(l, r))) {
                    return l;
                }
                char out = s.charAt(l++);
                windowHash = ((windowHash - RL * out) % Q + Q) % Q;
            }
        }
        return -1;
    }
}
