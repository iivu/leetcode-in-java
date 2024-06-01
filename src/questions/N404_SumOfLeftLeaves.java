package questions;

import utils.TreeNode;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
class SolutionN404_1 {
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

class SolutionN404_2 {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        traverse(root.left);
        traverse(root.right);
    }
}