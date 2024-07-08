package questions.n938_rangeSumBST;

import utils.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */

public class Solution1 {
    private int ans = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return ans;
    }

    private void traverse(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val < low) {
            traverse(root.right, low, high);
        }
        if (root.val > high) {
            traverse(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            ans += root.val;
            traverse(root.left, low, high);
            traverse(root.right, low, high);
        }
    }
}
