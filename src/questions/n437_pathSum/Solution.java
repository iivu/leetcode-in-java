package questions.n437_pathSum;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int ans = 0;
    private final Map<Long, Long> memo = new HashMap<>();
    private long sum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        // 注意base case
        memo.put(0L, 1L);
        traverse(root, targetSum);
        return ans;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        long need = sum - targetSum;
        if (memo.containsKey(need)) {
            ans += memo.get(need);
        }
        memo.put(sum, memo.getOrDefault(sum, 0L) + 1);
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        memo.put(sum, memo.get(sum) - 1);
        sum -= root.val;
    }
}
