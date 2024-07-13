package questions.n366_findLeaves;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的 root 节点，请按照以下方式收集树的节点：
 * <p>
 * 收集所有的叶子节点。
 * 移除所有的叶子节点。
 * 重复以上步骤，直到树为空。
 */
public class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        if (ans.size() < h) {
            ans.add(new ArrayList<>());
        }
        ans.get(h - 1).add(root.val);
        return h;
    }
}
