package questions.n285_inorderSuccessor;

import utils.TreeNode;

/**
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 * <p>
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点。
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode successor = null;
        if (root.val > p.val) {
            successor = inorderSuccessor(root.left, p);
            if (successor == null) {
                successor = root;
            }
        }

        if (root.val < p.val) {
            successor = inorderSuccessor(root.right, p);
        }

        if (root.val == p.val) {
            successor = getSuccessor(p.right);
        }
        return successor;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode p = node;
        while (p != null && p.left != null) {
            p = p.left;
        }
        return p;
    }
}
