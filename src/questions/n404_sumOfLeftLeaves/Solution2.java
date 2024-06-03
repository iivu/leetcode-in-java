package questions.n404_sumOfLeftLeaves;

import utils.TreeNode;

public class Solution2 {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        traverse(root.left);
        traverse(root.right);
    }
}