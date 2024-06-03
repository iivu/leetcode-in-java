package questions.n144_preorderTraversal;

import utils.TreeNode;

import java.util.ArrayList;
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
public class Solution1 {
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
