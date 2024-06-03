package questions.n199_rightSideView;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS
class Solution1 {
    private final Queue<TreeNode> queue = new LinkedList<>();
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                if (i == size - 1) {
                    ans.add(curr.val);
                }
            }
        }
        return ans;
    }
}
