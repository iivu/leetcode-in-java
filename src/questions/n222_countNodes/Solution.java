package questions.n222_countNodes;

import utils.TreeNode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
class Solution {
    public int countNodes(TreeNode root) {
        // 计算左右两边的树高
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        if (hl == hr) {
            // 说明已root为根节点的是一颗满二叉树
            return (int) Math.pow(2, hl) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}