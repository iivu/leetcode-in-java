package questions.n113_pathSum;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

// 分解子问题
public class Solution2 {
    private final List<Integer> paths = new LinkedList<>();
    private final List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        check(root, targetSum);
        return ans;
    }

    // 定义：给定二叉树的根节点root，检查从root到叶子节点，是否有一条路径和等于targetSum
    private void check(TreeNode root, int targetSum) {
        if (root == null){
            return;
        }
        paths.addLast(root.val);
        if (root.left == root.right && root.val == targetSum) {
            ans.add(new LinkedList<>(paths));
        }
        check(root.left, targetSum - root.val);
        check(root.right, targetSum - root.val);
        paths.removeLast();
    }
}
