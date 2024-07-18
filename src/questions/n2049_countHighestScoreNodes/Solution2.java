package questions.n2049_countHighestScoreNodes;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    private int[][] tree;
    private final Map<Long, Integer> scoreToCount = new HashMap<>();

    public int countHighestScoreNodes(int[] parents) {
        tree = buildTree(parents);
        count(0);
        long maxCore = 0;
        for (long score : scoreToCount.keySet()) {
            maxCore = Math.max(score, maxCore);
        }
        return scoreToCount.get(maxCore);
    }

    //定义，统计一棵树的节点数
    private int count(int root) {
        if (root == -1) {
            return 0;
        }
        int total = tree.length;
        int left = count(tree[root][0]);
        int right = count(tree[root][1]);
        int other = total - left - right - 1;
        long score = (long) Math.max(left, 1) * Math.max(right, 1) * Math.max(other, 1);
        scoreToCount.put(score, scoreToCount.getOrDefault(score, 0) + 1);
        return left + right + 1;
    }

    private int[][] buildTree(int[] parents) {
        int len = parents.length;
        int[][] tree = new int[len][2];
        for (int[] node : tree) {
            node[0] = -1;
            node[1] = -1;
        }
        for (int i = 1; i < len; i++) {
            int p = parents[i];
            int[] pNode = tree[p];
            if (pNode[0] == -1) {
                pNode[0] = i;
            } else {
                pNode[1] = i;
            }

        }
        return tree;
    }
}
