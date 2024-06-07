package questions.n112_hasPathSum;

import utils.TreeNode;

// 遍历
public class Solution2 {
    private int sum = 0;
    private boolean ans = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return ans;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            ans = true;
        }
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        sum -= root.val;
    }
}
