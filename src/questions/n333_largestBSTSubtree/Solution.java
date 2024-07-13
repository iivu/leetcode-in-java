package questions.n333_largestBSTSubtree;

import utils.TreeNode;

/**
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。
 * <p>
 * 二叉搜索树（BST）中的所有节点都具备以下属性：
 * <p>
 * 左子树的值小于其父（根）节点的值。
 * <p>
 * 右子树的值大于其父（根）节点的值。
 * <p>
 * 注意：子树必须包含其所有后代。
 */

public class Solution {
    private int ans = 0;

    public int largestBSTSubtree(TreeNode root) {
        findBST(root);
        return ans;
    }

    // 定义：寻找BST，[min,max,count]
    private int[] findBST(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = findBST(root.left);
        int[] right = findBST(root.right);

        // 左树或右树有一个不是BST，那root就不是BST
        if (left == null || right == null) {
            return null;
        }

        int leftMin = left[0], leftMax = left[1], leftCount = left[2];
        int rightMin = right[0], rightMax = right[1], rightCount = right[2];

        if (root.val > leftMax && root.val < rightMin) {
            int rootCount = leftCount + rightCount + 1;
            ans = Math.max(ans, rootCount);
            return new int[]{Math.min(leftMin, root.val), Math.max(rightMax, root.val), rootCount};
        }
        return null;
    }
}
