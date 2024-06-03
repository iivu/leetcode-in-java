package questions.n98_isValidBST;

import utils.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    private boolean check(TreeNode node, TreeNode max, TreeNode min) {
        if (node == null) {
            return true;
        }
        if (max != null && node.val >= max.val) {
            return false;
        }
        if (min != null && node.val <= min.val) {
            return false;
        }
        return check(node.left, node, min) && check(node.right, max, node);
    }
}