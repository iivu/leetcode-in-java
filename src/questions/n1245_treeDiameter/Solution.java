package questions.n1245_treeDiameter;

import java.util.*;

/**
 * 给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。
 * <p>
 * 我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。
 * <p>
 * 树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。
 */
public class Solution {
    private final Map<Integer, List<Integer>> tree = new HashMap<>();
    private final Set<Integer> visited = new HashSet<>();
    private int ans = Integer.MIN_VALUE;

    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        buildTree(edges);
        // 任意选择一个节点作为根节点
        maxDepth(edges[0][0]);
        return ans;
    }

    private void buildTree(int[][] edges) {
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (!tree.containsKey(a)) {
                tree.put(a, new ArrayList<>());
            }
            if (!tree.containsKey(b)) {
                tree.put(b, new ArrayList<>());
            }
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
    }

    private int maxDepth(int root) {
        if (visited.contains(root)) {
            // 由于是无向图，root也会保护父节点，因此要跳过
            return 0;
        }
        visited.add(root);
        int firstDepth = 0, secondDepth = 0;
        for (int c : tree.get(root)) {
            // 选两条最长的路径
            int depth = maxDepth(c);
            if (depth > firstDepth) {
                secondDepth = firstDepth;
                firstDepth = depth;
            } else if (depth > secondDepth) {
                secondDepth = depth;
            }
        }
        ans = Math.max(ans, firstDepth + secondDepth);
        return firstDepth + 1;
    }
}
