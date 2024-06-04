package questions.n1261_findElements;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElements {
    private final Set<Integer> memo = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;
        traverse(root);
    }

    public boolean find(int target) {
        return memo.contains(target);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        memo.add(root.val);
        if (root.left != null) {
            root.left.val = root.val * 2 + 1;
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 2;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
