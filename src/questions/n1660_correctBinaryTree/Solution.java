package questions.n1660_correctBinaryTree;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 你有一棵二叉树，这棵二叉树有个小问题，其中有且只有一个无效节点，它的右子节点错误地指向了与其在同一层且在其右侧的一个其他节点。
 *
 * 给定一棵这样的问题二叉树的根节点 root ，将该无效节点及其所有子节点移除（除被错误指向的节点外），然后返回新二叉树的根结点。
 */
public class Solution {
    private final Set<TreeNode> visited = new HashSet<>();
    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null && visited.contains(root.right)) {
            return null;
        }
        visited.add(root);
        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);
        return root;
    }
}
