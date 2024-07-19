package questions.n662_widthOfBinaryTree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 */
class Solution1 {
    private static class Node {
        public TreeNode val;
        public int id;

        public Node(TreeNode val, int id) {
            this.val = val;
            this.id = id;
        }
    }

    private int ans = 0;

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0;
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr != null && i == 0) {
                    start = curr.id;
                }
                if (curr != null && i == size - 1) {
                    end = curr.id;
                }
                if (curr != null && curr.val.left != null) {
                    queue.offer(new Node(curr.val.left, 2 * curr.id));
                }
                if (curr != null && curr.val.right != null) {
                    queue.offer(new Node(curr.val.right, 2 * curr.id + 1));
                }
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}