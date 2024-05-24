package questions;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 */
class SolutionN219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> count = new HashSet<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            int val = nums[r];
            if (count.contains(val)) {
                return true;
            }
            count.add(val);
            r++;
            if (r - l > k) {
                int out = nums[l];
                count.remove(out);
                l++;
            }
        }
        return false;
    }
}