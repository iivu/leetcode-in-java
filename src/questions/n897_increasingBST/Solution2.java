package questions.n897_increasingBST;

import utils.TreeNode;

public class Solution2 {
    private final TreeNode dump = new TreeNode(-1);
    private TreeNode curr = dump;
    public TreeNode increasingBST(TreeNode root) {
        traverse(root);
        return dump.right;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        traverse(root.right);
    }
}
