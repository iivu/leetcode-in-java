package questions.n304_numMatrix;

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * <p>
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * 实现 NumMatrix 类：
 * <p>
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
 */
class Solution {
    public class NumMatrix {
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            if (row == 0 || col == 0) return;
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