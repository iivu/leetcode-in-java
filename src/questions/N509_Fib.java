package questions;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 */

/**
 * 递归，通过「备忘录」记录已经计算过的结果，加速整个计算过程
 * 在递归图上表现就是“剪枝”--移除掉多余的部分
 */
class SolutionN509_1 {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    private int dp(int[] memo, int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (memo[n] == 0) {
            memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        }
        return memo[n];
    }
}

/**
 * 遍历，通过「dp表」依次计算数列中的每一个成员
 */
class SolutionN509_2 {
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

/**
 * 遍历，「dp表」的优化，因为n的状态只和n-1和n-2两个状态相关
 * 因此只需要2个变量保存n-1和n-2即可，不需要一整个数组，压缩空间
 */
class SolutionN509_3 {
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