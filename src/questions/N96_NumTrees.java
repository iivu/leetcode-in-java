package questions;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
class SolutionN96 {
    private int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    // 定义：[l,r]区间中可以组成的BST个数
    private int count(int l, int r) {
        if (l > r) {
            return 1;
        }
        if (memo[l][r] > 0) {
            return memo[l][r];
        }
        int res = 0;
        for (int i = l; i <= r; i++) {
            int lc = count(l, i - 1);
            int rc = count(i + 1, r);
            res += (lc * rc);
        }
        memo[l][r] = res;
        return res;
    }
}