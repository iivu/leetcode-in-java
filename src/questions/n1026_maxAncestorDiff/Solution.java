package questions.n1026_maxAncestorDiff;

import utils.TreeNode;

/**
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 */
public class Solution {
    private int ans = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        getMinMax(root);
        return ans;
    }

    // 定义：返回一颗树的最大值和最小值
    private int[] getMinMax(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = getMinMax(root.left);
        int[] right = getMinMax(root.right);
        int rootMin = min(root.val, left[0], right[0]);
        int rootMax = max(root.val, left[1], right[1]);
        ans = max(ans, Math.abs(root.val - rootMax), Math.abs(root.val - rootMin));
        return new int[]{rootMin, rootMax};
    }

    private int max(int v1, int v2, int v3) {
        return Math.max(v1, Math.max(v2, v3));
    }

    private int min(int v1, int v2, int v3) {
        return Math.min(v1, Math.min(v2, v3));
    }
}
