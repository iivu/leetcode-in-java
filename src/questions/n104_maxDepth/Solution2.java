package questions.n104_maxDepth;

import utils.TreeNode;

// 遍历整颗树，在节点前置位置计算深度
public class Solution2 {
    private int ans = 0;
    private int depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            ans = Math.max(depth, ans);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
