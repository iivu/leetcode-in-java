package questions;

/**
 * 给你一个已经 排好序 的整数数组 nums 和整数 a 、 b 、 c
 * 对于数组中的每一个元素 nums[i] ，计算函数值 f(x) = ax2 + bx + c
 * 请按升序返回数组
 */
class SolutionN360 {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        int[] ans = new int[len];
        int l = 0, r = len - 1, p = a > 0 ? len - 1 : 0;
        while (l <= r) {
            int vl = f(nums[l],a,b,c);
            int vr = f(nums[r],a,b,c);
            if (a > 0) {
                // 函数图像开口朝上，越靠近对称轴，值越小
                if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
                    ans[p] = vl;
                    l++;
                } else {
                    ans[p] = vr;
                    r--;
                }
                p--;
            } else {
                // 函数图像开口朝下，越靠近对称轴，值越大
                if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
                    ans[p] = vr;
                    r--;
                } else {
                    ans[p] = vl;
                    l++;
                }
                p++;
            }
        }
        return ans;
    }

    private int f(int x,int a, int b,int c) {
        return a * x * x + b * x + c;
    }
}