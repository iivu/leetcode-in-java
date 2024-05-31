package questions;

import utils.TreeNode;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * <p>
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 */
class SolutionN1022 {
    private int ans = 0;
    private int path = 0;

    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans += ((path << 1) | root.val);
            return;
        }
        path = ((path << 1) | root.val);
        traverse(root.left);
        traverse(root.right);
        path = path >> 1;
    }
}