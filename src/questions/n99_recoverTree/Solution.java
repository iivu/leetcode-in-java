package questions.n99_recoverTree;

import utils.TreeNode;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 */
public class Solution {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (root.val < prev.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}
