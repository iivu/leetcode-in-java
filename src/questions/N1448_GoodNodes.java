package questions;

import utils.TreeNode;

/**
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * <p>
 * 「好节点」X定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 */
class SolutionN1448 {
    private int ans = 0;

    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);
        return ans;
    }

    private void traverse(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            ans += 1;
        }
        max =Math.max(root.val, max);
        traverse(root.left, max);
        traverse(root.right, max);
    }
}