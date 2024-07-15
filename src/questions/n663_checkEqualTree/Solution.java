package questions.n663_checkEqualTree;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一棵二叉树的根节点 root，如果你可以通过去掉原始树上的一条边将树分成两棵节点值之和相等的子树，则返回 true。
 */
public class Solution {
    private final Set<Integer> sumSet = new HashSet<>();

    public boolean checkEqualTree(TreeNode root) {
        int treeSum = root.val + sum(root.left) + sum(root.right);
        if (treeSum % 2 != 0) {
            return false;
        }
        return sumSet.contains(treeSum / 2);
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int rootSum = leftSum + rightSum + root.val;
        sumSet.add(rootSum);
        return rootSum;
    }
}
