package questions.n101_isSymmetric;

import utils.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    // 定义：检查两棵树是否是镜像
    private boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return right == left;
        }
        if (left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
