package questions.n971_flipMatchVoyage;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
 * <p>
 * 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
 */
class Solution {

    private int p = 0;
    private List<Integer> ans = new ArrayList<>();
    private boolean canFlip = true;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        traverse(root, voyage);
        if (canFlip) {
            return ans;
        }
        return List.of(-1);
    }

    private void traverse(TreeNode root, int[] voyage) {
        if (root == null) {
            return;
        }
        if (root.val != voyage[p++]) {
            canFlip = false;
            return;
        }
        if (root.left != null && root.left.val != voyage[p]) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            ans.add(root.val);
        }
        traverse(root.left, voyage);
        traverse(root.right, voyage);
    }
}