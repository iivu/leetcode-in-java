package questions.n515_largestValues;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class Solution1 {
    public List<Integer> largestValues(TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        final List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    max = Math.max(max, curr.val);
                }
                if (curr != null && curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr != null && curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}
