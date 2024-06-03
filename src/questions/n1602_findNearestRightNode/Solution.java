package questions.n1602_findNearestRightNode;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null) {
            return null;
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.removeFirst();
                if (curr.val == u.val) {
                    if (i == size - 1) {
                        return null;
                    } else{
                        return queue.removeFirst();
                    }
                }
                if (curr.left != null) {
                    queue.addLast(curr.left);
                }
                if (curr.right != null) {
                    queue.addLast(curr.right);
                }
            }
        }
        return null;
    }
}