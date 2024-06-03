package questions.n240_searchMatrix;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列
 */
class Solution {
    // 从右上角开始出发，往左走会变小，往下走会变大
    // 根据当前的value和target的大小关系，决定搜索方向
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0, c = col - 1;
        while (r < row && c >= 0) {
            int val = matrix[r][c];
            if (val == target) {
                return true;
            }
            if (val < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}