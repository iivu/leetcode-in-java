package questions.n666_pathSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于一棵深度小于 5 的树，可以用一组三位十进制整数来表示。对于每个整数：
 * <p>
 * 百位上的数字表示这个节点的深度 d，1 <= d <= 4。
 * 十位上的数字表示这个节点在当前层所在的位置 P， 1 <= p <= 8。位置编号与一棵满二叉树的位置编号相同。
 * 个位上的数字表示这个节点的权值 v，0 <= v <= 9。
 * 给定一个包含三位整数的 升序 数组 nums ，表示一棵深度小于 5 的二叉树，请你返回 从根到所有叶子结点的路径之和 。
 * <p>
 * 保证 给定的数组表示一个有效的连接二叉树。
 */
public class Solution {
    // 记录每个节点编号和值的映射
    private final Map<Integer, Integer> values = new HashMap<>();
    private int ans = 0;
    private int path = 0;

    public int pathSum(int[] nums) {
        for (int num : nums) {
            values.put(num / 10, num % 10);
        }
        traverse(nums[0] / 10);
        return ans;
    }

    private void traverse(int root) {
        if (!values.containsKey(root)) {
            return;
        }
        path += values.get(root);
        int[] p = decode(root);
        // 左节点编号 root * 2 + 1, 右节点编号 root * 2,
        int leftCode = encode(p[0] + 1, p[1] * 2 - 1);
        int rightCode = encode(p[0] + 1, p[1] * 2);
        if (!values.containsKey(leftCode) && !values.containsKey(rightCode)) {
            ans += path;
        }
        traverse(leftCode);
        traverse(rightCode);
        path -= values.get(root);
    }

    // code -> [depth, position]
    private int[] decode(int code) {
        return new int[]{code / 10, code % 10};
    }

    // [depth, position] -> code
    private int encode(int depth, int position) {
        return depth * 10 + position;
    }
}
