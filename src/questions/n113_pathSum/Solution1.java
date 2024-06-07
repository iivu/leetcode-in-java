package questions.n113_pathSum;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 */

// 遍历
public class Solution1 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new LinkedList<>();
    private int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return ans;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.addLast(root.val);
        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            ans.add(new LinkedList<>(path));
        }
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        path.removeLast();
        sum -= root.val;
    }
}
