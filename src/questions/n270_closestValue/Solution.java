package questions.n270_closestValue;

import utils.TreeNode;

/**
 * 给你二叉搜索树的根节点 root 和一个目标值 target
 * 请在该二叉搜索树中找到最接近目标值 target 的数值。如果有多个答案，返回最小的那个。
 */
class Solution {
    private int ans = Integer.MIN_VALUE;

    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return ans;
    }

    private void traverse(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        // 在中序位置更新答案，保证返回的答案是最小的
        if (target > root.val) {
            // 马上要进入右树寻找可能的答案了
            // 但是为了保证答案是最小的，先更新一波
            if (Math.abs(root.val - target) < Math.abs(ans - target)) {
                ans = root.val;
            }
            traverse(root.right, target);
        } else {
            // 马上要进入左树寻找可能的答案了
            // 但是为了保证答案是最小的，先让左树更新完，再更新自己
            traverse(root.left, target);
            if (Math.abs(root.val - target) < Math.abs(ans - target)) {
                ans = root.val;
            }
        }
    }
}