package questions.n1325_removeLeafNodes;

import utils.TreeNode;

/**
 * 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
 * <p>
 * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
 * <p>
 * 也就是说，你需要重复此过程直到不能继续删除。
 */

public class Solution1 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        remove(root, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    private boolean remove(TreeNode root, int target) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null && root.val == target) {
            return true;
        }
        boolean removeLeft = remove(root.left, target);
        boolean removeRight = remove(root.right, target);
        if (removeLeft) {
            root.left = null;
        }
        if (removeRight) {
            root.right = null;
        }
        return removeLeft && removeRight && root.val == target;
    }
}
