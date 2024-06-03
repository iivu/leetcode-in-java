package questions.n90_subsetsWithDup;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
class Solution {
    private final List<List<Integer>> ans = new LinkedList<>();
    private final List<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先对数组排序，让所有相同的数都靠在一起
        Arrays.sort(nums);
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int start) {
        // 每进入一个节点，就是一个新的结果集
        ans.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                // 跳过重复的元素
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            // 进入下一个选择
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}