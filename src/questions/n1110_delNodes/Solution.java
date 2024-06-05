package questions.n1110_delNodes;

import utils.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 */
public class Solution {
    private final List<TreeNode> ans = new LinkedList<>();
    private final Set<Integer> toDeletSet = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return ans;
        }
        for (int i : to_delete) {
            toDeletSet.add(i);
        }
        del(root, null);
        return ans;
    }

    // 定义：输入一个树，删掉to_delete中的所有节点，并返回根节点
    private TreeNode del(TreeNode root, TreeNode parent) {
        if (root == null) {
            return null;
        }
        boolean deleted = toDeletSet.contains(root.val);
        if (parent == null && !deleted) {
            ans.add(root);
        }
        root.left = del(root.left, deleted ? null : root);
        root.right = del(root.right, deleted ? null : root);
        return deleted ? null : root;
    }
}
