package questions;

import utils.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
class SolutionN230 {
    private int ck = 0;
    private  int ans  = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }

    private void traverse(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        traverse(node.left, k);
        ck++;
        if (ck == k) {
            ans = node.val;
        }
        traverse(node.right, k);
    }
}