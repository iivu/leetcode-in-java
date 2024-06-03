package questions.n654_constructMaximumBinaryTree;

import utils.TreeNode;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int maxIndex = getMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = build(nums, start, maxIndex);
        root.right = build(nums, maxIndex + 1, end);
        return root;
    }

    private int getMaxIndex(int[] nums, int start, int end) {
        int result = start;
        for (int i = start; i < end; i++) {
            if (nums[i] >= nums[result]) {
                result = i;
            }
        }
        return result;
    }
}