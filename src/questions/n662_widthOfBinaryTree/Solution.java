package questions.n662_widthOfBinaryTree;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 */
class Solution {
    private final Queue<TreeNode> queue = new LinkedList<>();
    private int ans = 0;

    // TODO...
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return ans;
        }
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        int maxH = Math.max(hl, hr);
        int currH = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            currH++;
            Deque<TreeNode> count = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (currH <= maxH) {
                    if (curr == null) {
                        queue.offer(null);
                        queue.offer(null);

                    } else {
                        queue.offer(curr.left);
                        queue.offer(curr.right);
                    }
                }
                count.addLast(curr);
            }
            while (!count.isEmpty() && count.peekFirst() == null) {
                count.removeFirst();
            }
            while (!count.isEmpty() && count.peekLast() == null) {
                count.removeLast();
            }
            ans = Math.max(ans, count.size());
        }
        return ans;
    }
}