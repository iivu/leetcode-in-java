package questions.n220_containsNearByAlmostDuplicate;

import java.util.Set;
import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 * <p>
 * 找出满足下述条件的下标对 (i, j)：
 * <p>
 * i != j,
 * abs(i - j) <= indexDiff
 * abs(nums[i] - nums[j]) <= valueDiff
 * 如果存在，返回 true ；否则，返回 false 。
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> window = new TreeSet<>();
        int l = 0 , r = 0;
        while (r < nums.length) {
            int val = nums[r];
            Integer ceiling = window.ceiling(val);
            if (ceiling != null && ceiling - val <= valueDiff) {
                return true;
            }
            Integer floor = window.floor(val);
            if (floor != null && val - floor <= valueDiff) {
                return true;
            }
            window.add(val);
            r++;
            if (r - l > indexDiff) {
                int out = nums[l];
                window.remove(out);
                l++;
            }
        }
        return false;
    }
}