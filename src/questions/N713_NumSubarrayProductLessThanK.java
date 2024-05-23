package questions;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 */
class SolutionN713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int l = 0, r = 0, curr = 1;
        int ans = 0;
        while (r < nums.length) {
            curr *= nums[r++];
            while (curr >= k && l < r) {
                curr /= nums[l++];
            }
            // 此时的子数组满足要求，但是子数组的子数组也会满足要求
            // 例如：[1,2,3]满足了要求，那么[3],[2,3] 也会满足要求
            ans += (r - l);
        }
        return ans;
    }
}