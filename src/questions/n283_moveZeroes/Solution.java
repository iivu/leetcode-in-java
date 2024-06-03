package questions.n283_moveZeroes;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * 进阶：你能尽量减少完成的操作次数吗？
 */
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        // 先移除数组中的0，得到移除0后的数组长度
        int p = removeElement(nums, 0);
        // p = 0 说明数组中没有0
        if (p == nums.length) {
            return;
        }
        // [p, num.length-1]赋值为0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    private int removeElement(int[] nums, int val) {
        int len = nums.length;
        int slow = 0, fast = 0;
        while (fast < len) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}