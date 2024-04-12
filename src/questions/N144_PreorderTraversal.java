package questions;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 */
// 1. 递归，遍历每一个节点
class SolutionN144_1 {
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}

// 2. 递归，分解子问题
class SolutionN144_2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return traverse(root);
    }

    private List<Integer> traverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(traverse(root.left));
        result.addAll(traverse(root.right));
        return result;
    }
}

// 3. 遍历
class SolutionN144_3 {
    private final List<Integer> ans = new ArrayList<>();
    private final Deque<TreeNode> nodes = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        nodes.addFirst(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.removeFirst();
            ans.add(node.val);
            if (node.right != null) {
                nodes.addFirst(node.right);
            }
            if (node.left != null) {
                nodes.addFirst(node.left);
            }
        }
        return ans;
    }
}