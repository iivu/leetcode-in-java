package questions.n322_coinChange;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 */

/**
 * 1. base case: amount = 0，不需要硬币；amount < 0
 * 2. 状态：amount。选择不同的硬币，amount会发生变化。
 * 3. 选择：coins。我们在选择硬币
 * 4. 明确dp函数的定义：要凑出amount，至少需要dp(coins, amount)个硬币;
 * <p>
 * 解法1会超时，需要备忘录剪枝
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    // dp: 要凑出amount，至少需要dp(coins,amount)个硬币;
    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            ans = Math.min(ans, sub + 1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}
