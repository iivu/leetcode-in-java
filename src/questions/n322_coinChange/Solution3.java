package questions.n322_coinChange;

import java.util.Arrays;

/**
 * 用dp数组代替dp函数，迭代求解
 * dp数组的定义：当目标金额为i时，需要最少dp[i]个硬币凑出
 */
public class Solution3 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}