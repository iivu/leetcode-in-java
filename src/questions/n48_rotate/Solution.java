package questions.n48_rotate;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 沿 [0,0]-[n-1,n-1] 这条对角线镜像matrix
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        // 再反转每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}