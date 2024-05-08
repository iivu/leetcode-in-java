package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回k次迁移操作后最终得到的二维网格。
 */
class SolutionN1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        if (k % (row * col) == 0) {
            return toList(grid);
        }
        k = k % (row * col);
        int[] flattedGrid = flat(grid);
        int[] ansArray = new int[flattedGrid.length];
        System.arraycopy(flattedGrid, 0, ansArray, k, flattedGrid.length - k);
        System.arraycopy(flattedGrid, flattedGrid.length - k, ansArray, 0, k);
        return toList(ansArray, col);
    }

    private List<List<Integer>> toList(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> rowList = new ArrayList<>();
            for (int v : row) {
                rowList.add(v);
            }
            res.add(rowList);
        }
        return res;
    }

    private List<List<Integer>> toList(int[] grid, int col) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> rowList = new ArrayList<>();
        for (int v : grid) {
            rowList.add(v);
            if (rowList.size() == col) {
                res.add(rowList);
                rowList = new ArrayList<>();
            }
        }
        return res;
    }

    private int[] flat(int[][] grid) {
        int[] res = new int[grid.length * grid[0].length];
        int p = 0;
        for (int[] row : grid) {
            for (int i : row) {
                res[p] = i;
                p++;
            }
        }
        return res;
    }
}