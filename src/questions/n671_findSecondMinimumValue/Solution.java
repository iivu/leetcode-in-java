package questions.n671_findSecondMinimumValue;

import utils.TreeNode;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
 * <p>
 * 如果第二小的值不存在的话，输出 -1 。
 */
public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null || root.right == null) {
            return -1;
        }
        int left = root.left.val, right = root.right.val;
        if (root.val == left) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.val == right) {
            right = findSecondMinimumValue(root.right);
        }
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }
}
