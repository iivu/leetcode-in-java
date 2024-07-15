package questions.n2049_countHighestScoreNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。
 * <p>
 * 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。
 * <p>
 * 请你返回有 最高得分 节点的 数目 。
 */

public class Solution {
    private static class TreeNode {
        private final int val;
        private final List<TreeNode> children = new ArrayList<>();

        public TreeNode(int val) {
            this.val = val;
        }

        public void addChild(TreeNode node) {
            children.add(node);
        }

        public int getChildrenCount() {
            return children.size();
        }

        public TreeNode getChild(int index) {
            return children.get(index);
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", children=" + children +
                    '}';
        }
    }

    private int totalCount = 0;
    private Map<Long, Integer> scoreMap;

    public int countHighestScoreNodes(int[] parents) {
        TreeNode root = buildTree(parents);
        totalCount = count(root);
        scoreMap = new HashMap<>();
        count(root);
        long maxScore = Integer.MIN_VALUE;
        for (long k : scoreMap.keySet()) {
            maxScore = Math.max(k, maxScore);
        }
        return scoreMap.get(maxScore);
    }

    private TreeNode buildTree(int[] parents) {
        int len = parents.length;
        TreeNode[] nodes = new TreeNode[len];

        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode(i);
        }
        for (int i = 1; i < len; i++) {
            int p = parents[i];
            nodes[p].addChild(nodes[i]);
        }
        return len == 0 ? null : nodes[0];
    }

    // 定义：返回一棵树的节点数目
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int total = 1;
        int remain = totalCount - 1;
        long score = 1;
        for (int i = 0; i < root.getChildrenCount(); i++) {
            int childCount = count(root.getChild(i));
            remain -= childCount;
            score *= Math.max(childCount, 1);
            total += childCount;
        }
        score *= (Math.max(remain, 1));
        if (scoreMap != null) {
            scoreMap.put(score, scoreMap.getOrDefault(score, 0) + 1);
        }
        return total;
    }
}
