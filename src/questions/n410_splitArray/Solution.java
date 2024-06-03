package questions.n410_splitArray;

/**
 * 给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。
 * <p>
 * 设计一个算法使得这 k 个子数组各自和的最大值最小。
 */
class Solution {

    // 和1011十分类似
    // 分割数组就是船装货物；分成k个就k天运完货物；所求的值就是这个船的最小运载力
    public int splitArray(int[] nums, int k) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int num : nums) {
            min = Math.max(num, min);
            max += num;
        }
        int l = min , r = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (f(mid,nums) <= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 含义：一个子数组和的最大值为max，求能分出几个子数组（子数组的和要尽量接近max）
    // 也类似于装货物，船要尽量装满
    private int f(int max, int[] nums) {
        int result = 1;
        int total = 0;
        for (int num : nums) {
            if (total + num <= max) {
                total += num;
            } else {
                result++;
                total = num;
            }
        }
        return result;
    }
}