package questions.n776_splitBST;

import utils.TreeNode;

/**
 * 给你一棵二叉搜索树（BST）的根结点 root 和一个整数 target 。请将该树按要求拆分为两个子树：其中第一个子树结点的值都必须小于等于给定的目标值；另一个子树结点的值都必须大于目标值；树中并非一定要存在值为 target 的结点。
 * <p>
 * 除此之外，树中大部分结构都需要保留，也就是说原始树中父节点 p 的任意子节点 c ，假如拆分后它们仍在同一个子树中，那么结点 p 应仍为 c 的父结点。
 * <p>
 * 按顺序返回 两个子树的根结点的数组 。
 */
public class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode[2];
        }
        TreeNode[] res = new TreeNode[2];
        if (root.val <= target) {
            res[0] = root;
            TreeNode[] right = splitBST(root.right, target);
            res[1] = right[1];
            root.right = right[0];
        } else {
            res[1] = root;
            TreeNode[] left = splitBST(root.left,target);
            res[0] = left[0];
            root.left = left[1];
        }
        return res;
    }
}
