package questions.n814_pruneTree;

import utils.TreeNode;

/**
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 */
public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return traverse(root);
    }

    private TreeNode traverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = traverse(root.left);
        root.right = traverse(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
