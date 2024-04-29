package questions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * <p>
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 */

class SolutionN378 {

    // 合并K个有序链表思想
    public int kthSmallest(int[][] matrix, int k) {
        int ans = -1;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            queue.offer(new int[]{row[0], i, 0});
        }
        while (!queue.isEmpty() && k > 0) {
            int[] curr = queue.poll();
            int value = curr[0], row = curr[1], col = curr[2];
            k--;
            ans = value;
            if (col < matrix[row].length - 1) {
                queue.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        return ans;
    }
}