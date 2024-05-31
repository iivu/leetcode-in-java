package questions;

import utils.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
class SolutionN235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        return traverse(root, p, q);
    }

    // p是较小值，q是较大值
    public TreeNode traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val < p.val) {
            return traverse(root.right, p, q);
        }
        if (root.val > q.val) {
            return traverse(root.left, p, q);
        }
        return root;
    }
}