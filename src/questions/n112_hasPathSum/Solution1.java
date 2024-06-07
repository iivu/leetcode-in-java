package questions.n112_hasPathSum;

import utils.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 */

// 分解子问题
public class Solution1 {
    //定义：给定一个二叉树根节点root，判断：从root开始到叶子节点，是否有一条路径和等于targetSum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 隐含意义：left == right == null
        if (root.left == root.right && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
