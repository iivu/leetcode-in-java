package questions.n1161_maxLevelSum;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 */
public class Solution {
    public int maxLevelSum(TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE, level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    continue;
                }
                sum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
            if (sum == maxSum) {
                ans = Math.min(level, ans);
            }
        }
        return ans;
    }
}
