package questions.n894_allPossibleFBT;

import utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
 * <p>
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
 * <p>
 * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
 */
public class Solution {
    private final Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new LinkedList<>();
        }
        return build(n);
    }

    // 定义：给定一个n，返回所有可能的真二叉树，节点的数量为n
    private List<TreeNode> build(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        for (int i = 1; i < n; i += 2) {
            // i: 左树用i个节点构建；因为根节点用了1个，所以左树从1开始；又因为是一个真二叉树，所以每次步进2
            // j: 右树用j个节点构建
            int j = n - i - 1;
            List<TreeNode> left = build(i);
            List<TreeNode> right = build(j);
            // 组装所有可能的形状
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        memo.put(n, res);
        return res;
    }
}
