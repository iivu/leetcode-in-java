package questions;

import java.util.ArrayList;
import java.util.List;

class SolutionN54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> ans = new ArrayList<>(row * col);
        // 设立边界
        int leftB = 0, rightB = col - 1, topB = 0, bottomB = row - 1;
        while (ans.size() < row * col) {
            if (topB <= bottomB) {
                for (int c = leftB; c <= rightB; c++) {
                    ans.add(matrix[topB][c]);
                }
                topB++;
            }
            if (rightB >= leftB) {
                for (int r = topB; r <= bottomB; r++) {
                    ans.add(matrix[r][rightB]);
                }
                rightB--;
            }
            if (bottomB >= topB) {
                for (int c = rightB; c >= leftB; c--) {
                    ans.add(matrix[bottomB][c]);
                }
                bottomB--;
            }
            if (leftB <= rightB) {
                for (int r = bottomB; r >= topB; r--) {
                    ans.add(matrix[r][leftB]);
                }
                leftB++;
            }
        }
        return ans;
    }
}