package questions.n1161_maxLevelSum;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
