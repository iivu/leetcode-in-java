package questions;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
class SolutionN95 {
    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    // 定义：【l,r】中构造出所有合法的BST根节点
    public List<TreeNode> build(int l, int r) {
        List<TreeNode> res = new LinkedList<>();
        if (l > r) {
            // 进入了这个分支，说明在构建叶子节点，那么叶子节点的子节点就是null
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftTrees = build(l, i - 1);
            List<TreeNode> rightTrees = build(i + 1, r);
            for (TreeNode left :  leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}