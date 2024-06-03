package questions.n315_countSmaller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。
 * 数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 nums[i] 的元素的数量。
 */
class Solution {
    private static class Pair {
        public int index, val;

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    private int[] count;
    private Pair[] temp;

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        count = new int[len];
        temp = new Pair[len];
        Pair[] arr = new Pair[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Pair(i, nums[i]);
        }
        sort(arr, 0, len - 1);
        List<Integer> ans = new ArrayList<>();
        for (int v : count) {
            ans.add(v);
        }
        return ans;
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
        int l = start, r = mid + 1;
        for (int p = start; p <= end; p++) {
            if (l == mid + 1) {
                arr[p] = temp[r++];
            } else if (r == end + 1) {
                arr[p] = temp[l];
                count[arr[p].index] += (r - mid - 1);
                l++;
            } else if (temp[l].val > temp[r].val) {
                arr[p] = temp[r++];
            } else if (temp[l].val <= temp[r].val) {
                arr[p] = temp[l];
                count[arr[p].index] += (r - mid - 1);
                l++;
            }
        }
    }
}