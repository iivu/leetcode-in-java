package questions.n637_averageOfLevels;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    sum += curr.val;
                }
                if (curr != null && curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr != null && curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ans.add(sum / size);
        }
        return ans;
    }
}
