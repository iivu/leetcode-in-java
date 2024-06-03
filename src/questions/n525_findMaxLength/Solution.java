package questions.n525_findMaxLength;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        int ans = 0;
        // 题目的意思可以理解为：
        // 0可以看作-1. 即为寻找和为0的最长子数组
        // 寻找i和j, preSum[i] - preSum[j] == 0 && i > j && i与j相差足够大
        int[] preSum = new int[len + 1];
        for (int i = 1; i< len + 1; i++) {
            preSum[i] = preSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        Map<Integer,Integer> memo = new HashMap<>();
        for (int i = 0;i<len + 1;i++) {
            if (!memo.containsKey(preSum[i])) {
                memo.put(preSum[i], i);
            } else {
                ans = Math.max(ans, i - memo.get(preSum[i]));
            }
        }
        return ans;
    }
}