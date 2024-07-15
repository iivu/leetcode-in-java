package questions.n1339_maxProduct;

import utils.TreeNode;

/**
 * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 * <p>
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 */
public class Solution {
    private int treeSum = 0;
    private long ans = Long.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        treeSum = sum(root);
        ans = Integer.MIN_VALUE;
        sum(root);
        return (int) (ans % (1e9 + 7));
    }

    // 定义：对一棵树求和
    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        int rootSum = left + right + root.val;
        ans = Math.max(ans, (long) (treeSum - rootSum) * rootSum);
        return rootSum;
    }
}
