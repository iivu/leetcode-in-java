package questions;

import utils.TreeNode;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */

// 分解子问题，左节点的深度和右节点深度最大的一个，加上自己
class SolutionN104_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}

// 遍历整颗树，在节点前置位置计算深度
class SolutionN104_2 {
    private int ans = 0;
    private int depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            ans = Math.max(depth, ans);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}