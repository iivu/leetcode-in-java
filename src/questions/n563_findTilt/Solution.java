package questions.n563_findTilt;

import utils.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
 * <p>
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 * <p>
 * 整个树 的坡度就是其所有节点的坡度之和。
 */
public class Solution {
    private int ans = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return ans;
    }

    // 定义：计算节点和
    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        ans += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
