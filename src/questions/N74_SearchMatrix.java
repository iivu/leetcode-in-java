package questions;

class SolutionN74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, r = row * col - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (get(matrix, mid) == target) {
                return true;
            }
            if (get(matrix,mid) > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }


    private int get(int[][] matrix, int index) {
        int col = matrix[0].length;
        return matrix[index / col][index % col];
    }
}