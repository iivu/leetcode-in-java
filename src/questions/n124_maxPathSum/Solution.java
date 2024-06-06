package questions.n124_maxPathSum;

import utils.TreeNode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Solution {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ans;
    }

    // 定义：计算root为起点的单边最大路径和
    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lm = Math.max(0, getMax(root.left));
        int rm = Math.max(0, getMax(root.right));
        int max = lm + root.val + rm;
        ans = Math.max(max, ans);
        return Math.max(lm, rm) + root.val;
    }
}
