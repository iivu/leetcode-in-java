package questions.n1120_maximumAverageSubtree;

import utils.TreeNode;

/**
 * 给你一棵二叉树的根节点 root，找出这棵树的 每一棵 子树的 平均值 中的 最大 值。
 * <p>
 * 子树是树中的任意节点和它的所有后代构成的集合。
 * <p>
 * 树的平均值是树中节点值的总和除以节点数。
 */
public class Solution {
    private double ans = Double.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        traverse(root);
        return ans;
    }

    // 定义：返回树的节点总数量和总和
    private int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int rootCount = left[0] + right[0] + 1;
        int rootTotal = left[1] + right[1] + root.val;
        ans = Math.max(ans, (double) rootTotal / rootCount);
        return new int[]{rootCount, rootTotal};
    }
}
