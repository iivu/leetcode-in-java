package questions.n1379_getTargetCopy;

import utils.TreeNode;

/**
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
 * <p>
 * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
 * <p>
 * 请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 * <p>
 * 注意：你 不能 对两棵二叉树，以及 target 节点进行更改。只能 返回对克隆树 cloned 中已有的节点的引用。
 */

public class Solution1 {
    private TreeNode ans;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        traverse(original, cloned, target);
        return ans;
    }

    private void traverse(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (ans != null || original == null) {
            return;
        }
        if (original == target) {
            ans = cloned;
            return;
        }
        traverse(original.left, cloned.left, target);
        traverse(original.right, cloned.right, target);
    }
}
