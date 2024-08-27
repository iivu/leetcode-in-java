package questions.n1008_bstFromPreorder;

import utils.TreeNode;

/**
 * 给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
 * <p>
 * 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
 * <p>
 * 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大于 Node.val。
 * <p>
 * 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
 */
public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    // 定义：
    // 在区间[start,end]构建BST，并返回根节点
    private TreeNode build(int[] data, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(data[start]);
        int p = start + 1;
        while (p <= end && data[p] < root.val) {
            p++;
        }
        root.left = build(data, start + 1, p - 1);
        root.right = build(data, p, end);
        return root;
    }
}
