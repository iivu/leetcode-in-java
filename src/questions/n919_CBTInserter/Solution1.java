package questions.n919_CBTInserter;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * <p>
 * 实现 CBTInserter 类:
 * <p>
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点
 */
public class Solution1 {
    static class CBTInserter {
        private final TreeNode root;
        private final Queue<TreeNode> queue;
        private int size = 0;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.queue = new LinkedList<>();
            queue.offer(root);
        }

        public int insert(int val) {
            while (!queue.isEmpty()) {
                size = queue.size();
                while (size != 0) {
                    TreeNode curr = queue.peek();
                    if (curr == null) {
                        continue;
                    }
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                    if (curr.left != null && curr.right != null) {
                        queue.poll();
                        size -= 1;
                        continue;
                    }
                    if (curr.left == null) {
                        curr.left = new TreeNode(val);
                    } else {
                        curr.right = new TreeNode(val);
                    }
                    return curr.val;
                }
            }
            return -1;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
