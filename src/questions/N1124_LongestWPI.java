package questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 */
class SolutionN1124 {
    public int longestWPI(int[] hours) {
        int len = hours.length;
        int[] preSum = new int[len + 1];
        int ans = 0;
        for (int i = 1; i < len + 1; i++) {
            preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
        }
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < len + 1; i++) {
            if (!memo.containsKey(preSum[i])) {
                memo.put(preSum[i], i);
            }
            if (preSum[i] > 0) {
                ans = Math.max(ans, i);
            } else {
                if (memo.containsKey(preSum[i] - 1)) {
                    ans = Math.max(ans, i - memo.get(preSum[i] - 1));
                }
            }
        }
        return ans;
    }
}