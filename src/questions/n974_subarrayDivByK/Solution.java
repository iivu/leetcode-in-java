package questions.n974_subarrayDivByK;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
 * <p>
 * 子数组 是数组的 连续 部分
 */
class Solution {
    // 题目可以理解为，寻找i和j，i<j, sum([i..j]) % k == 0
    // 这个等式可以转换为:
    // (sum([0..j]) - sum([0..i])) % k == 0
    // (sum([0..j) % k) - (sum([0..j]) %) == 0
    // sum([0..i]) % k == sum([0..j]) % k
    public int subarraysDivByK(int[] nums, int k) {
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
            int need = preSum[i] % k;
            if (need < 0) {
                need += k;
            }
            if (memo.containsKey(need)) {
                ans += memo.get(need);
                memo.put(need, memo.get(need) + 1);
            } else {
                memo.put(need, 1);
            }
        }
        return ans;
    }
}