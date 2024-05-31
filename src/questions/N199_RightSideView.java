package questions;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS
class SolutionN199_1 {
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

// DFS
class SolutionN199_2 {
    private int depth = 0;
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (ans.size() < depth) {
            // 说明该层还未记录值
            ans.add(root.val);
        }
        traverse(root.right);
        traverse(root.left);
        depth--;
    }
}