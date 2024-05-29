package questions;

import utils.TreeNode;

import java.util.HashMap;

/**
 * 给定两个整数数组，preorder 和 postorder ，
 * 其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 */
class SolutionN889 {
    private final HashMap<Integer, Integer> postorderMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postorderMap.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = postorderMap.get(preorder[preStart + 1]);
        int leftSize = index - postStart + 1;
        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);
        return root;
    }
}