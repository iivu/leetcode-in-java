package questions;

import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
class SolutionN215 {
    // 第k大的元素，即升序后的数组nums[nums.length - k]个元素
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
//        int pivot = randomPivot(nums, lo, hi);
        // [lo,i) < pivot,[i,j] == pivot, (j,hi] > pivot
        int i = lo, j = hi;
        while (true) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, lo, j);
        return j;
    }

    private int randomPivot(int[] nums, int lo, int hi) {
        Random random = new Random();
        int i = random.nextInt(hi - lo + 1) + lo;
        swap(nums, lo, i);
        return nums[lo];
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int r = i + random.nextInt(nums.length - i);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}