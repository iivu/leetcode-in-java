package questions.n39_combinationSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> track = new ArrayList<>();
    private int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates, 0, target);
        return ans;
    }

    private void backtrace(int[] nums, int start, int target) {
        if (trackSum >= target) {
            if (trackSum == target) {
                ans.add(new LinkedList<>(track));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 做选择
            trackSum += nums[i];
            track.addLast(nums[i]);
            // 进入下一个抉择
            backtrace(nums, i, target);
            // 撤销选择
            trackSum -= nums[i];
            track.removeLast();
        }
    }
}