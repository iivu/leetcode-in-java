package questions.n1469_getLonelyNodes;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中，如果一个节点是其父节点的唯一子节点，则称这样的节点为 “独生节点” 。二叉树的根节点不会是独生节点，因为它没有父节点。
 * <p>
 * 给定一棵二叉树的根节点 root ，返回树中 所有的独生节点的值所构成的数组 。数组的顺序 不限
 */
class Solution {
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right != null) {
            ans.add(root.right.val);
        }
        if (root.left != null && root.right == null) {
            ans.add(root.left.val);
        }
        traverse(root.left);
        traverse(root.right);
    }
}