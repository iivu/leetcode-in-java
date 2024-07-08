package questions.n1379_getTargetCopy;

import utils.TreeNode;

public class Solution2 {
    // 定义：找出目标节点
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        return left == null ? getTargetCopy(original.right, cloned.right, target) : left;
    }
}
