package questions.n2928_distributeCandies;

class Solution {
    private int ans = 0;

    public int distributeCandies(int n, int limit) {
        backtrace(n, limit, 1);
        return ans;
    }

    private void backtrace(int n, int limit, int count) {
        if (count == 3) {
            if (n <= limit && n >= 0) {
                ans += 1;
            }
            return;
        }
        for (int i = 0; i <= Math.min(limit, n); i++) {
            backtrace(n - i, limit, count + 1);
        }
    }
}