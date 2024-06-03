package questions.n226_invertTree;

import utils.TreeNode;

// 分解子问题思路
public class Solution2 {
    // 定义：传入以root的为根的二叉树，反转这棵树，并返回根节点
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}