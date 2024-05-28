package questions;

import utils.TreeNode;


// 遍历思路
class SolutionN226_1 {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        traverse(node.left);
        traverse(node.right);
    }
}

// 分解子问题思路
class SolutionN226_2 {
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