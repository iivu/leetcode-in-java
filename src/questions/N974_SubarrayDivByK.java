package questions;

import java.util.HashMap;
import java.util.Map;

class SolutionN974 {
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