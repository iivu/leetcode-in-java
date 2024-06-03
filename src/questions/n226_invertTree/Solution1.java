package questions.n226_invertTree;

import utils.TreeNode;


// 遍历思路
class Solution1 {
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
