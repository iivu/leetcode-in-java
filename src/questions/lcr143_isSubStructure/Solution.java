package questions.lcr143_isSubStructure;

import utils.TreeNode;

/**
 * 给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 * 注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 */

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val && check(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean check(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return check(A.left, B.left) && check(A.right, B.right);
    }
}
