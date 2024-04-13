package questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
class SolutionN47 {
    private final List<List<Integer>> ans = new LinkedList<>();
    private final List<Integer> track = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, used);
        return ans;
    }

    public void backtrack(int[] nums, boolean[] used) {
        if (track.size() == nums.length) {
            ans.add(new LinkedList<>(track));
            return;
        }
        int prev = -666;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (nums[i] == prev) {
                // 避免选择相同的分支，去重
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            used[i] = true;
            prev = nums[i];
            // 进入下一个抉择
            backtrack(nums, used);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }
}