package questions.n11_isBalanced;

import utils.TreeNode;

/**
 * 给定一个二叉树，判断它是否是 平衡二叉树
 */

public class Solution {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (!isBalanced) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
