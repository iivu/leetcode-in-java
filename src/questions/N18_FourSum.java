package questions;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由n个整数组成的数组nums，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
 * 若两个四元组元素一一对应，则认为两个四元组重复
 */
class SolutionN18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        return Utils.nSumTarget(nums, 4, 0, target);
    }
}