package questions;

class SolutionN283 {
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