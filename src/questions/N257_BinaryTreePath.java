package questions;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
class SolutionN257 {
    private final List<String> ans = new ArrayList<>();
    private final List<TreeNode> memo = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        memo.addLast(root);
        if (root.left == null && root.right == null) {
            ans.add(memo.stream().map(node -> Integer.toString(node.val)).collect(Collectors.joining("->")));
            memo.removeLast();
            return;
        }
        traverse(root.left);
        traverse(root.right);
        memo.removeLast();
    }
}