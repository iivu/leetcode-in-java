package questions.n897_increasingBST;

import utils.TreeNode;

/**
 * 给你一棵二叉搜索树的 root ，
 * 请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
 * 并且每个节点没有左子节点，只有一个右子节点。
 */
// 分解子问题
public class Solution1 {

    // 定义：给一个二叉搜索树根节点root，返回链表
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = increasingBST(root.left);
        root.left = null;
        root.right = increasingBST(root.right);
        if (left == null) {
            return root;
        }
        TreeNode p = left;
        while (p.right != null) {
            p = p.right;
        }
        p.right = root;
        return left;
    }

}
