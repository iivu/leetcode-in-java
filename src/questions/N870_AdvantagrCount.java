package questions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给定两个长度相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 */
class SolutionN870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> maxQ2 = new PriorityQueue<>((int[] pair1, int[] pari2) -> pari2[1] - pair1[1]);
        for (int i = 0; i < nums2.length; i++) {
            maxQ2.add(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int l = 0, r = nums1.length - 1;
        int[] ans = new int[nums1.length];
        while (!maxQ2.isEmpty()) {
            // 解题思路类似田忌赛马：
            // 拿出nums2中最大的数字
            int[] pair = maxQ2.poll();
            if (nums1[r] > pair[1]) {
                // nums1中最大的比nums2最大的数大，那就和nums2比
                ans[pair[0]] = nums1[r];
                r--;
            } else {
                // nums1中最大的比不过nums2最大的，那就用nums1中最小的去送人头
                ans[pair[0]] = nums1[l];
                l++;
            }
        }
        return ans;
    }
}