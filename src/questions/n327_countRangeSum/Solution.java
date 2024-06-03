package questions.n327_countRangeSum;


/**
 * 给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，
 * 值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
 * <p>
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 */
class Solution {
    private int lower = 0;
    private int upper = 0;
    private int count = 0;
    private long[] temp;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        long[] preSum = new long[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        temp = new long[preSum.length];
        sort(preSum, 0, preSum.length - 1);
        return count;
    }

    private void sort(long[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(long[] nums, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        // 计算区间和
        // 维护一个区间[a,b), 使得[a,b)的前缀和于nums[i]的差，落在[lower,upper]
        int a = mid + 1, b = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (a <= end && nums[a] - nums[i] < lower) {
                a++;
            }
            while (b <= end && nums[b] - nums[i] <= upper) {
                b++;
            }
            count += (b - a);
        }
        // 计算区间和
        int l = start, r = mid + 1;
        for (int p = start; p <= end; p++) {
            if (l == mid + 1) {
                nums[p] = temp[r++];
            } else if (r == end + 1) {
                nums[p] = temp[l++];
            } else if (temp[l] <= temp[r]) {
                nums[p] = temp[l++];
            } else {
                nums[p] = temp[r++];
            }
        }
    }
}