package questions.n977_sortedSquares;

/**
 * 给你一个按非递减顺序排序的整数数组nums，
 * 返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int l = 0, r = len - 1, p = len - 1;
        while (l <= r) {
            if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
                ans[p] = nums[l] * nums[l];
                l++;
            } else {
                ans[p] = nums[r] * nums[r];
                r--;
            }
            p--;
        }
        return ans;
    }
}