package questions.n919_CBTInserter;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    static class CBTInserter {
        private final TreeNode root;
        private final Queue<TreeNode> canInsertTreeNodeQueue;
        private int size = 0;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.canInsertTreeNodeQueue = new LinkedList<>();
            Queue<TreeNode> temp = new LinkedList<>();
            temp.offer(root);
            while (!temp.isEmpty()) {
                int size = temp.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = temp.poll();
                    if (curr == null) {
                        continue;
                    }
                    if (curr.left != null) {
                        temp.offer(curr.left);
                    }
                    if (curr.right != null) {
                        temp.offer(curr.right);
                    }
                    if (curr.left == null || curr.right == null) {
                        canInsertTreeNodeQueue.offer(curr);
                    }
                }
            }
        }

        public int insert(int val) {
            TreeNode curr = canInsertTreeNodeQueue.peek();
            if (curr == null) {
                return -1;
            }
            TreeNode newTreeNode = new TreeNode(val);
            canInsertTreeNodeQueue.offer(newTreeNode);
            if (curr.left == null) {
                curr.left = newTreeNode;
            } else {
                curr.right = newTreeNode;
                canInsertTreeNodeQueue.poll();
            }
            return curr.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
