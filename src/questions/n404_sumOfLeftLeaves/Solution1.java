package questions.n404_sumOfLeftLeaves;

import utils.TreeNode;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class Solution1 {
    private enum Position {
        LEFT, RIGHT
    }

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root, null);
        return sum;
    }

    private void traverse(TreeNode root, Position p) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && p == Position.LEFT) {
            sum += root.val;
            return;
        }
        traverse(root.left, Position.LEFT);
        traverse(root.right, Position.RIGHT);
    }
}
