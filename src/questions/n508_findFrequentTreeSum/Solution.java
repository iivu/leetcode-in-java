package questions.n508_findFrequentTreeSum;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 */
public class Solution {
    private final HashMap<Integer, Integer> sumToCount = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        int maxCount = 0;
        for (int count : sumToCount.values()) {
            maxCount = Math.max(maxCount, count);
        }
        List<Integer> ans = new ArrayList<>();
        for (int sum : sumToCount.keySet()) {
            if (sumToCount.get(sum) == maxCount) {
                ans.add(sum);
            }
        }
        int[] ansArray = new int[ans.size()];
        for (int i = 0; i < ansArray.length; i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

    // 定义：计算树root的节点和（包括根节点）
    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int rootSum = leftSum + rightSum + root.val;
        sumToCount.put(rootSum, sumToCount.getOrDefault(rootSum, 0) + 1);
        return rootSum;
    }
}
