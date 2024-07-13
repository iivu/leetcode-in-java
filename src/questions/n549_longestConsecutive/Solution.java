package questions.n549_longestConsecutive;

import utils.TreeNode;

public class Solution {
    private int ans = 0;

    public int longestConsecutive(TreeNode root) {
        getLongestConsecutive(root);
        return ans;
    }

    // 定义：获取树的最长连续递增/递减序列
    // 返回: [递增序列长度，递减序列长度]
    private int[] getLongestConsecutive(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = getLongestConsecutive(root.left);
        int[] right = getLongestConsecutive(root.right);
        int leftIncr = left[0], leftDecr = left[1];
        int rightIncr = right[0], rightDecr = right[1];
        int rootIncr = 1, rootDecr = 1;
        if (root.left != null) {
            if (root.val + 1 == root.left.val) {
                rootIncr += leftIncr;
            }
            if (root.val - 1 == root.left.val) {
                rootDecr += leftDecr;
            }
        }
        if (root.right != null) {
            if (root.val + 1 == root.right.val) {
                rootIncr = Math.max(rootIncr, rightIncr + 1);
            }
            if (root.val - 1 == root.right.val) {
                rootDecr = Math.max(rootDecr, rightDecr + 1);
            }
        }

        ans = Math.max(ans, rootIncr + rootDecr - 1);
        return new int[]{rootIncr, rootDecr};
    }
}
