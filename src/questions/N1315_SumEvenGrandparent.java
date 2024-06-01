package questions;

import utils.TreeNode;

/**
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 */
class SolutionN1315 {
    private int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val % 2 == 0 && root.left != null) {
            if (root.left.left != null) {
                sum += root.left.left.val;
            }
            if (root.left.right != null) {
                sum += root.left.right.val;
            }
        }
        if (root.val % 2 == 0 && root.right != null) {
            if (root.right.left != null) {
                sum += root.right.left.val;
            }
            if (root.right.right != null) {
                sum += root.right.right.val;
            }
        }
        traverse(root.left);
        traverse(root.right);
    }
}