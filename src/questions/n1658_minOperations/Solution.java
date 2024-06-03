package questions.n1658_minOperations;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
 * 然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 */
class Solution {
    public int minOperations(int[] nums, int x) {
        int l = 0, r = 0, sum = 0, windowSum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        while (r < nums.length) {
            windowSum += nums[r++];
            while (windowSum > target && l < r) {
                windowSum -= nums[l++];
            }
            if (windowSum == target) {
                maxLen = Math.max(maxLen, r - l);
            }
        }
        return maxLen == Integer.MIN_VALUE ? -1 : nums.length - maxLen;
    }
}