package questions.n144_preorderTraversal;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 3. 遍历
public class Solution3 {
    private final List<Integer> ans = new ArrayList<>();
    private final Deque<TreeNode> nodes = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        nodes.addFirst(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.removeFirst();
            ans.add(node.val);
            if (node.right != null) {
                nodes.addFirst(node.right);
            }
            if (node.left != null) {
                nodes.addFirst(node.left);
            }
        }
        return ans;
    }
}
