package questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 */
class SolutionN523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len  = nums.length;
        if (len < 2) {
            return false;
        }
        Map<Integer,Integer> memo = new HashMap<>();
        int[] preSum = new int[len + 1];
        for (int i = 1; i< preSum.length;i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0 ; i< preSum.length;i++) {
            if (!memo.containsKey(preSum[i] % k)) {
                memo.put(preSum[i] % k, i);
            } else {
                if (i - memo.get(preSum[i] % k) >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}