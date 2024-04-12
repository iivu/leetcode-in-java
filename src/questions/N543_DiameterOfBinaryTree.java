package questions;

import utils.TreeNode;

/**
 * 给你一棵二叉树的根节点，返回该树的直径。
 * <p>
 * 二叉树的直径是指树中任意两个节点之间最长路径的长度。这条路径可能经过也可能不经过根节点root。
 * <p>
 * 两节点之间路径的长度由它们之间边数表示。
 */
class SolutionN543 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        max = Math.max(leftMaxDepth + rightMaxDepth, max);
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }
}