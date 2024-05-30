package questions;

import utils.TreeNode;

class SolutionN538 {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.right);
        sum += node.val;
        node.val = sum;
        traverse(node.left);
    }
}