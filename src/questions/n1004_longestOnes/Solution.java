package questions.n1004_longestOnes;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;
        int windowOneCount = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] == 1) {
                windowOneCount++;
            }
            r++;
            while (r - l - windowOneCount > k) {
                int out = nums[l];
                if (out == 1) {
                    windowOneCount--;
                }
                l++;

            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}