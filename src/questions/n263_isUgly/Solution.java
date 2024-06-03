package questions.n263_isUgly;

/**
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * <p>
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 */
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        // 如果一个数是n丑数，那可以写作：n = 2^a * 3^b * 5^c
        // 当 a == b == c == 0 时，n = 1
        // 因此可以不断的除每一个因子，直到abc都为0，再看最后的结果是不是等于1
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}