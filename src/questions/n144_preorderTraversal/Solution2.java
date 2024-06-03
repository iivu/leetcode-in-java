package questions.n144_preorderTraversal;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 2. 递归，分解子问题
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return traverse(root);
    }

    private List<Integer> traverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(traverse(root.left));
        result.addAll(traverse(root.right));
        return result;
    }
}
