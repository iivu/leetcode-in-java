package questions.n199_rightSideView;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// DFS
public class Solution2 {
    private int depth = 0;
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (ans.size() < depth) {
            // 说明该层还未记录值
            ans.add(root.val);
        }
        traverse(root.right);
        traverse(root.left);
        depth--;
    }
}