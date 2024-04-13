package questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 */
class SolutionN40 {
    private final List<List<Integer>> ans = new LinkedList<>();
    private final List<Integer> track = new LinkedList<>();
    private int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return ans;
    }

    private void backtrack(int[] nums, int start, int target) {
        if (trackSum >= target) {
            if (trackSum == target) {
                ans.add(new LinkedList<>(track));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i -1]) {
                continue;
            }
            // 做选择
            trackSum += nums[i];
            track.addLast(nums[i]);
            // 进入下一个抉择
            backtrack(nums, i + 1, target);
            // 撤销选择
            trackSum -= nums[i];
            track.removeLast();
        }
    }

}