package questions.n129_sumNumbers;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * <p>
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点
 */
class Solution {
    private int ans = 0;
    private final StringBuilder memo = new StringBuilder();
    public int sumNumbers(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        memo.append(root.val);
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(memo.toString());
            memo.deleteCharAt(memo.length() - 1);
            return;
        }
        traverse(root.left);
        traverse(root.right);
        memo.deleteCharAt(memo.length() - 1);
    }
}