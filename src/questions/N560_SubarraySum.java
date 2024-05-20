package questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 */
class SolutionN560 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        int ans = 0;
        int[] preSum = new int[len + 1];
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int need = preSum[i] - k;
            if (memo.containsKey(need)) {
                ans += memo.get(need);
            }
            if (!memo.containsKey(preSum[i])) {
                memo.put(preSum[i], 1);
            } else {
                memo.put(preSum[i], memo.get(preSum[i]) + 1);
            }
        }
        return ans;
    }
}