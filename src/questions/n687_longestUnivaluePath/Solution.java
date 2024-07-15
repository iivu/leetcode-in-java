package questions.n687_longestUnivaluePath;

import utils.TreeNode;

/**
 * 给定一个二叉树的root，返回最长的路径的长度，这个路径中的 每个节点具有相同值。
 * 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度 由它们之间的边数表示
 */
public class Solution {
    private int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getLongestUnivaluePath(root, root.val);
        return ans;
    }

    // 定义：计算从root开始，值为parentVal的最长路径
    private int getLongestUnivaluePath(TreeNode root, int parentVal) {
        if (root == null) {
            return 0;
        }
        int leftLen = getLongestUnivaluePath(root.left, root.val);
        int rightLen = getLongestUnivaluePath(root.right, root.val);
        ans = Math.max(ans, leftLen + rightLen);
        if (root.val != parentVal) {
            return 0;
        }
        return 1 + Math.max(leftLen, rightLen);
    }
}
