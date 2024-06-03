package questions.n298_longestConsecutive;

import utils.TreeNode;

/**
 * 给你一棵指定的二叉树的根节点 root ，请你计算其中 最长连续序列路径 的长度。
 * <p>
 * 最长连续序列路径 是依次递增 1 的路径。该路径，可以是从某个初始节点到树中任意节点，
 * 通过「父 - 子」关系连接而产生的任意路径。且必须从父节点到子节点，反过来是不可以的。
 */
class Solution {
    private int ans = Integer.MIN_VALUE;

    public int longestConsecutive(TreeNode root) {
        traverse(root, 1, root.val);
        return ans;
    }

    private void traverse(TreeNode node, int currLen, int p) {
        if (node == null) {
            return;
        }
        if (p + 1 == node.val) {
            currLen += 1;
        } else {
            currLen = 1;
        }
        ans = Math.max(ans, currLen);
        traverse(node.left, currLen, node.val);
        traverse(node.right, currLen, node.val);
    }
}