package questions.n250_countUnivalSubtrees;

import utils.TreeNode;

/**
 * 给定一个二叉树，统计该二叉树数值相同的子树个数。
 * <p>
 * 同值子树是指该子树的所有节点都拥有相同的数值。
 */

public class Solution {
    private int ans = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return ans;
        }
        getUnivalue(root);
        return ans;
    }

    // 定义：给定一个树root，如果该树的每个节点值都相同，则返回该值，否则返回Integer.MIN_VALUE
    private int getUnivalue(TreeNode root) {
        int leftVal = root.left == null ? root.val : getUnivalue(root.left);
        int rightVal = root.right == null ? root.val : getUnivalue(root.right);

        if (leftVal == Integer.MIN_VALUE || rightVal == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (leftVal == rightVal && root.val == leftVal) {
            ans++;
            return root.val;
        }
        return Integer.MIN_VALUE;
    }
}
