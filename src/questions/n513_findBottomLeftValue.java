package questions;

import utils.TreeNode;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 */
public class n513_findBottomLeftValue {
    private int maxDepth = 0;
    private int currDepth = 0;
    private int ans = 0;

    public int findBottomLeftValue(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        currDepth += 1;
        if (currDepth > maxDepth) {
            maxDepth = currDepth;
            if (root.left == null && root.right == null) {
                ans = root.val;
            }
        }
        traverse(root.left);
        traverse(root.right);
        currDepth -= 1;
    }
}
