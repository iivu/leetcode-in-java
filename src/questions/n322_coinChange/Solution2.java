package questions.n322_coinChange;

import java.util.Arrays;

/**
 * 同解法1，但是带上了备忘录，加速计算过程
 */
public class Solution2 {
    private final static int EMPTY_FLAG = -10;

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, EMPTY_FLAG);
        return dp(memo, coins, amount);
    }

    // dp: 要凑出amount，至少需要dp(coins,amount)个硬币;
    private int dp(int[] memo, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != EMPTY_FLAG) {
            return memo[amount];
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(memo, coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            ans = Math.min(ans, sub + 1);
        }
        memo[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;
        return memo[amount];
    }
}