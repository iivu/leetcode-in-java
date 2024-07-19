package questions.n662_widthOfBinaryTree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private int ans = 1;
    private final List<Integer> firstIds = new ArrayList<>();

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root, 1, 1);
        return ans;
    }

    private void traverse(TreeNode root, int id, int depth) {
        if (root == null) {
            return;
        }
        if (firstIds.size() == depth - 1) {
            firstIds.add(id);
        } else {
            ans = Math.max(ans, id - firstIds.get(depth - 1) + 1);
        }
        traverse(root.left, id * 2, depth + 1);
        traverse(root.right, id * 2 + 1, depth + 1);
    }
}
