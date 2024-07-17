package questions.n1080_sufficientSubset;

import utils.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
 * <p>
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
 * <p>
 * 叶子节点，就是没有子节点的节点。
 */
public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.val < limit) {
                return null;
            }
            return root;
        }
        TreeNode left = sufficientSubset(root.left, limit - root.val);
        TreeNode right = sufficientSubset(root.right, limit - root.val);
        if (left == null && right == null) {
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
