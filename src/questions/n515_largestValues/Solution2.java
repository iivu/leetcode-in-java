package questions.n515_largestValues;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        traverse(root, 1);
        return ans;
    }

    private void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (ans.size() == depth - 1) {
            ans.add(root.val);
        } else {
            ans.set(depth - 1, Math.max(root.val, ans.get(depth - 1)));
        }
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }
}
