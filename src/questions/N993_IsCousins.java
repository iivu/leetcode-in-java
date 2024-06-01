package questions;

import utils.TreeNode;

class SolutionN993 {
    private int depthX = 0;
    private int depthY = 0;
    private TreeNode parentX;
    private TreeNode parentY;
    private int currDepth = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        traverse(root, null, x, y);
        return depthX == depthY && parentX != null && parentY != null && parentY != parentX;
    }

    private void traverse(TreeNode root, TreeNode parent, int x, int y) {
        if (root == null) {
            return;
        }
        currDepth += 1;
        if (root.val == x) {
            depthX = currDepth;
            parentX = parent;
            currDepth -= 1;
            return;
        }
        if (root.val == y) {
            depthY = currDepth;
            parentY = parent;
            currDepth -= 1;
            return;
        }
        traverse(root.left, root, x, y);
        traverse(root.right, root, x, y);
        currDepth -= 1;
    }
}