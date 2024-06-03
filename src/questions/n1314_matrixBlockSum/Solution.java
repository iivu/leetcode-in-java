package questions.n1314_matrixBlockSum;

/**
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 * <p>
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c) 在矩阵内。
 * 示例 1：
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 */
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length;
        if (row == 0) {
            return new int[][]{};
        }
        int col = mat[0].length;
        if (col == 0) {
            return new int[][]{};
        }
        int[][] ans = new int[row][col];
        NumMatrix numMatrix = new NumMatrix(mat);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int r1 = Math.max(0, r - k);
                int c1 = Math.max(0, c - k);
                int r2 = Math.min(row - 1, r + k);
                int c2 = Math.min(col - 1, c + k);
                ans[r][c] = numMatrix.sumRegion(r1, c1, r2, c2);
            }
        }
        return ans;
    }

    public static class NumMatrix {
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int row = matrix.length;
            if (row == 0) return;
            int col = matrix[0].length;
            if (col == 0) return;
            preSum = new int[row + 1][col + 1];
            for (int r = 1; r <= row; r++) {
                for (int c = 1; c <= col; c++) {
                    preSum[r][c] = preSum[r - 1][c] + preSum[r][c - 1] + matrix[r - 1][c - 1] - preSum[r - 1][c - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
        }
    }
}