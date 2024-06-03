package questions.n509_fib;

/**
 * 遍历，「dp表」的优化，因为n的状态只和n-1和n-2两个状态相关
 * 因此只需要2个变量保存n-1和n-2即可，不需要一整个数组，压缩空间
 */
public class Solution3 {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int dpTable1 = 0;
        int dpTable2 = 1;
        for (int i = 2; i <= n; i++) {
            int val = dpTable1 + dpTable2;
            dpTable1 = dpTable2;
            dpTable2 = val;
        }
        return dpTable2;
    }
}
