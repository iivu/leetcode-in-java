package questions;

class SolutionN62 {
    private int ans = 0;
    private final int[] curr = new int[]{1, 1};

    public int uniquePaths(int m, int n) {
        backtrack(m, n);
        return ans;
    }

    private void backtrack(int m, int n) {
        if (curr[0] == m && curr[1] == n) {
            ans++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            // 0向右移动1向下移动
            if (i == 0 && canMoveRight(n)) {
                curr[1]++;
                backtrack(m, n);
                curr[1]--;
            }
            if (i == 1 && canMoveBottom(m)) {
                curr[0]++;
                backtrack(m, n);
                curr[0]--;
            }
        }
    }

    private boolean canMoveRight(int n) {
        return curr[1] < n;
    }

    private boolean canMoveBottom(int m) {
        return curr[0] < m;
    }
}