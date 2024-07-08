package questions.n1430_isValidSequence;

import utils.TreeNode;

/**
 * 给定一个二叉树，我们称从根节点到任意叶节点的任意路径中的节点值所构成的序列为该二叉树的一个“有效序列”。
 * 检查一个给定的序列是否是给定二叉树的一个 “有效序列”。
 * <p>
 * 我们以整数数组 arr 的形式给出这个序列。从根节点到任意叶节点的任意路径中的节点值所构成的序列都是这个二叉树的 “有效序列” 。
 */
public class Solution1 {

    private boolean ans = false;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        traverse(root, arr, 0);
        return ans;
    }

    private void traverse(TreeNode root, int[] arr, int index) {
        if (root == null || ans) {
            return;
        }
        if (index >= arr.length || root.val != arr[index]) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (index == arr.length - 1 && root.val == arr[index]) {
                ans = true;
            }
            return;
        }
        traverse(root.left, arr, index + 1);
        traverse(root.right, arr, index + 1);
    }
}
