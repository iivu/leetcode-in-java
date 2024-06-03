package questions.n493_reversePairs;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 */
class Solution {
    private static class Pair {
        public int index, val;

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    private int count = 0;
    private Pair[] temp;

    public int reversePairs(int[] nums) {
        int len = nums.length;
        temp = new Pair[len];
        Pair[] arr = new Pair[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Pair(i, nums[i]);
        }
        sort(arr, 0, len - 1);
        return count;
    }

    private void sort(Pair[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(Pair[] arr, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        // 核心逻辑
        int bound = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (bound <= end && (long) arr[i].val > (long) arr[bound].val * 2) {
                bound++;
            }
            count += bound - (mid + 1);
        }
        // 核心逻辑
        int l = start, r = mid + 1;
        for (int p = start; p <= end; p++) {
            if (l == mid + 1) {
                arr[p] = temp[r++];
            } else if (r == end + 1) {
                arr[p] = temp[l++];
            } else if (temp[l].val > temp[r].val) {
                arr[p] = temp[r++];
            } else if (temp[l].val <= temp[r].val) {
                arr[p] = temp[l++];
            }
        }
    }
}