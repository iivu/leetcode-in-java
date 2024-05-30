package questions;

import utils.TreeNode;

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