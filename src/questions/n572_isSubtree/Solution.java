package questions.n572_isSubtree;

import utils.TreeNode;

/**
 * 给你两棵二叉树 root 和 subRoot 。
 * 检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 */
public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        if (check(root, subRoot)) {
            return true;
        }
        return check(root.left, subRoot) || check(root.right, subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return check(root.left, subRoot.left) && check(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
