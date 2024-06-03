package questions.n623_addOneRow;

import utils.TreeNode;

/**
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * <p>
 * 注意，根节点 root 位于深度 1 。
 * <p>
 * 加法规则如下:
 * <p>
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 */
class Solution {
    private int targetDepth = 0;
    private int targetVal = 0;
    private int currDepth = 0;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        targetDepth = depth;
        targetVal = val;
        if (targetDepth == 1) {
            TreeNode newRoot = new TreeNode(targetVal);
            newRoot.left = root;
            return newRoot;
        }
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        currDepth += 1;
        if (currDepth == targetDepth - 1) {
            TreeNode newLeft = new TreeNode(targetVal);
            TreeNode newRight = new TreeNode(targetVal);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
        }
        traverse(root.left);
        traverse(root.right);
        currDepth -= 1;
    }
}