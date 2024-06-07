package questions.n617_mergeTrees;

import utils.TreeNode;

// 遍历
public class Solution2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        traverse(root1, root2);
        return root1;
    }

    private void traverse(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return;
        }
        root1.val = root1.val + root2.val;
        if (root1.left == null && root2.left != null) {
            root1.left = root2.left;
            root2.left = null;
        }
        if (root1.right == null && root2.right != null) {
            root1.right = root2.right;
            root2.right = null;
        }
        traverse(root1.left,root2.left);
        traverse(root1.right,root2.right);
    }
}
