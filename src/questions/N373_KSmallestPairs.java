package questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2) ... (uk,vk) 。
 */
class SolutionN373 {
    // 类似合并K个有序链表的思路
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));
        for(int i = 0; i< nums1.length;i++) {
            queue.offer(new int[]{ nums1[i], nums2[0], 0 });
        }
        while (!queue.isEmpty() && k > 0) {
            int[] curr = queue.poll();
            k--;
            int num1 = curr[0], num2 = curr[1], num2Index = curr[2];
            List<Integer> ca = new ArrayList<>();
            ca.add(num1);
            ca.add(num2);
            ans.add(ca);
            if (num2Index < nums2.length - 1) {
                queue.offer(new int[]{ num1, nums2[num2Index + 1], num2Index + 1 });
            }
        }
        return ans;
    }
}