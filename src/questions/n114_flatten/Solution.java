package questions.n114_flatten;

import utils.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
class Solution {
    // 定义：传入root为根节点的二叉树，拉平这颗树的子节点
    public void flatten(TreeNode root) {
        if (root == null) return;
        // 拉平左右子树
        flatten(root.left);
        flatten(root.right);

        TreeNode l = root.left;
        TreeNode r = root.right;
        // left子树拼接到right
        root.left = null;
        root.right = l;

        // right子树拼接到末尾
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = r;
    }
}
