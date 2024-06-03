package questions.n62_uniquePaths;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
class Solution {
    private int ans = 0;

    // TODO: 超时
    public int uniquePaths(int m, int n) {
        // memo记录已经走过的格子
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        backtrack(1, 1, m, n, memo);
        return ans;
    }

    private int backtrack(int cm, int cn, int m, int n, int[][] memo) {
        if (cm == m && cn == n) {
            ans++;
            return 1;
        }
        if (memo[cm][cn] != -1) {
            ans++;
            return 1;
        }
        if (canMoveRight(cn, n)) {
           backtrack(cm, cn + 1, m, n, memo);
        }
        if (canMoveBottom(cm, m)) {
            return memo[cm][cn] = backtrack(cm + 1, cn, m, n, memo);
        }
        return -1;
    }

    private boolean canMoveRight(int cn, int n) {
        return cn < n;
    }

    private boolean canMoveBottom(int cm, int m) {
        return cm < m;
    }
}