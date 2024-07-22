package questions.n863_distanceK;

import utils.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k ，返回到目标结点 target 距离为 k 的所有结点的值的数组。
 * <p>
 * 答案可以以 任何顺序 返回。
 */
public class Solution {
    private final List<Integer> ans = new ArrayList<>();
    private final Map<Integer, TreeNode> parents = new HashMap<>();
    private int depth = 0;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        traverse(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    continue;
                }
                visited.add(curr.val);
                if (depth == k) {
                    ans.add(curr.val);
                }
                TreeNode p = parents.get(curr.val);
                if (p != null && !visited.contains(p.val)) {
                    queue.offer(p);
                }
                if (curr.left != null && !visited.contains(curr.left.val)) {
                    queue.offer(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right.val)) {
                    queue.offer(curr.right);
                }
            }
            depth++;
        }
        return ans;
    }

    private void traverse(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        parents.put(root.val, p);
        traverse(root.left, root);
        traverse(root.right, root);
    }
}
