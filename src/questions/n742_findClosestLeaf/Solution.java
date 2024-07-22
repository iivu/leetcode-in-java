package questions.n742_findClosestLeaf;

import utils.TreeNode;

import java.util.*;

/**
 * 给定一个 每个结点的值互不相同 的二叉树，和一个目标整数值 k，返回 树中与目标值 k 最近的叶结点 。
 * <p>
 * 与叶结点最近 表示在二叉树中到达该叶节点需要行进的边数与到达其它叶结点相比最少。而且，当一个结点没有孩子结点时称其为叶结点。
 */
public class Solution {
    private TreeNode target;
    private final Map<Integer, TreeNode> parents = new HashMap<>();

    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        traverse(root, null, k);
        if (target == null) {
            return -1;
        }
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
                if (curr.left == null && curr.right == null) {
                    return curr.val;
                }
                TreeNode p = parents.get(curr.val);
                if (p!=null && !visited.contains(p.val)) {
                    queue.offer(p);
                }
                if (curr.left != null && !visited.contains(curr.left.val)) {
                    queue.offer(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right.val)) {
                    queue.offer(curr.right);
                }
            }
        }
        return -1;
    }

    private void traverse(TreeNode root, TreeNode p, int k) {
        if (root == null) {
            return;
        }
        parents.put(root.val, p);
        if (root.val == k) {
            target = root;
            return;
        }
        traverse(root.left, root, k);
        traverse(root.right, root, k);
    }
}
