package questions.n509_fib;

/**
 * 遍历，通过「dp表」依次计算数列中的每一个成员
 */
public class Solution2 {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dpTable = new int[n + 1];
        dpTable[0] = 0;
        dpTable[1] = 1;
        for (int i = 2; i <= n; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
        }
        return dpTable[n];
    }
}
