package questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */

// 「盒」视角，穷举每个位置可以放什么「球」
class SolutionN78_1 {
    private final List<List<Integer>> ans = new LinkedList<>();
    private final List<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int start) {
        // 每次进入一个节点，就是一个结果集
        ans.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 进入下一层选择
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}

// 「球」视角，「球」可以穷举自己可以在什么位置
class SolutionN78_2 {
    private final List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums);
        return ans;
    }

    private void backtrace(int[] nums) {

    }
}