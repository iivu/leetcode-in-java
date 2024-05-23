package questions;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
class SolutionN59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int val = 1;
        int leftB = 0, rightB = n - 1, topB = 0, bottomB = n - 1;
        while (val <= n * n) {
            if (topB <= bottomB) {
                for (int c = leftB; c <= rightB; c++) {
                    ans[topB][c] = val++;
                }
                topB++;
            }
            if (rightB >= leftB) {
                for (int r = topB; r <= bottomB; r++) {
                    ans[r][rightB] = val++;
                }
                rightB--;
            }
            if (bottomB >= topB) {
                for (int c = rightB; c >= leftB; c--) {
                    ans[bottomB][c] = val++;
                }
                bottomB--;
            }
            if (leftB <= rightB) {
                for (int r = bottomB; r >= topB; r--) {
                    ans[r][leftB] = val++;
                }
                leftB++;
            }
        }
        return ans;
    }
}