package questions.n865_subtreeWithAllDeepest;

import utils.TreeNode;

public class Solution {
    private static class Result {
        public int depth;
        public TreeNode node;

        public Result(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        Result r = traverse(root);
        return r.node;
    }

    private Result traverse(TreeNode root) {
        if (root == null) {
            return new Result(0, null);
        }
        Result l = traverse(root.left);
        Result r = traverse(root.right);
        if (l.depth == r.depth) {
            return new Result(l.depth + 1, root);
        }
        Result c = l.depth > r.depth ? l : r;
        c.depth++;
        return c;
    }
}
