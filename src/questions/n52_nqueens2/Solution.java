package questions.n52_nqueens2;

import java.util.Arrays;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 */
class Solution {
    private final static char EMPTY = '.';
    private final static char PLACED = 'Q';
    private int ans = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, EMPTY);
        }
        backtrace(board, 0);
        return ans;
    }

    private void backtrace(char[][] board, int row) {
        if (row == board.length) {
            ans++;
            return;
        }
        for (int i = 0; i < board[row].length; i++) {
            // 过滤哪个位置可以选择 （选择列表）
            if (!validPosition(board, row, i)) {
                continue;
            }
            // 做选择，这一行我选择在哪个位置放置
            board[row][i] = PLACED;
            // 进入下一行选择
            backtrace(board, row + 1);
            // 撤销选择
            board[row][i] = EMPTY;
        }
    }

    private boolean validPosition(char[][] board, int row, int col) {
        if (row == 0) {
            return true;
        }
        // 检查上方是否有皇后
        for (int r = 0; r < row; r++) {
            if (board[r][col] == PLACED) {
                return false;
            }
        }
        // 检查左上角是否有皇后
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == PLACED) {
                return false;
            }
        }
        // 检查右上角是否有皇后
        for (int r = row - 1, c = col + 1; r >= 0 && c < board[0].length; r--, c++) {
            if (board[r][c] == PLACED) {
                return false;
            }
        }
        return true;
    }
}