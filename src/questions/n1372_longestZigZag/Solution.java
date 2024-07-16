package questions.n1372_longestZigZag;

import utils.TreeNode;

/**
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * <p>
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * <p>
 * 请你返回给定树中最长 交错路径 的长度。
 */
public class Solution {
    private int ans = Integer.MIN_VALUE;

    public int longestZigZag(TreeNode root) {
        getPathLen(root);
        return ans;
    }

    // 定义：返回值有两个，1.从根节点root开始向左走的长度、2.从根节点root开始向右走的长度
    private int[] getPathLen(TreeNode root) {
        if (root == null) {
            // 取-1可以cover掉“访问过的节点数目 - 1“这个情况
            return new int[]{-1, -1};
        }
        int[] left = getPathLen(root.left);
        int[] right = getPathLen(root.right);
        int rootLeftLen = left[1] + 1;
        int rootRightLen = right[0] + 1;
        ans = Math.max(ans, Math.max(rootLeftLen, rootRightLen));
        return new int[]{rootLeftLen, rootRightLen};
    }
}
