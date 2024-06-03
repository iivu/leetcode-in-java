package questions.n105_buildTree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点
 */
class Solution {

    private final Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    // 根据前序遍历和后序遍历序列的特点构建即可
    private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = inorderMap.get(root.val);
        int leftSize = index - inStart;
        root.left = build(preorder, inorder, preStart + 1, preStart + leftSize, inStart, index - 1);
        root.right = build(preorder, inorder, preStart + leftSize + 1, preEnd , index + 1, inEnd);
        return root;
    }
}